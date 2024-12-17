package com.axiome.generadorpartetrabajo.service;

import com.axiome.generadorpartetrabajo.entity.Cliente;
import com.axiome.generadorpartetrabajo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    // Crear un cliente
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente por ID
    public boolean eliminarCliente(Long clienteID) {
        if (clienteRepository.existsById(clienteID)) {
            clienteRepository.deleteById(clienteID);
            return true;  // Se eliminó exitosamente
        }
        return false;  // No se encontró el cliente
    }

    // Obtener un cliente por su ID
    public Cliente obtenerCliente(Long clienteID) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteID);
        return cliente.orElse(null);  // Si el cliente no existe, retorna null
    }

    // Actualizar un cliente por su ID
    public Cliente actualizarCliente(Long clienteID, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(clienteID);

        if (clienteExistente.isPresent()) {
            Cliente clienteActualizado = clienteExistente.get();
            // Actualiza los campos que desees
            clienteActualizado.setNombre(cliente.getNombre());
            clienteActualizado.setCorreoContacto(cliente.getCorreoContacto());
            clienteActualizado.setTelefonoContacto(cliente.getTelefonoContacto());

            return clienteRepository.save(clienteActualizado);  // Guarda los cambios
        }
        return null;  // Si el cliente no existe, retorna null
    }
}
