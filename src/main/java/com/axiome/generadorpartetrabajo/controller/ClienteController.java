package com.axiome.generadorpartetrabajo.controller;

import com.axiome.generadorpartetrabajo.entity.Cliente;
import com.axiome.generadorpartetrabajo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")  // URL base para todas las operaciones de clientes
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde Angular
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Crear un nuevo cliente (POST)
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    // Obtener todos los clientes (GET)
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Obtener un cliente por ID (GET)
    @GetMapping("/{clienteID}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long clienteID) {
        Cliente cliente = clienteService.obtenerCliente(clienteID);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Si no se encuentra, devuelve un 404
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    // Actualizar un cliente (PUT)
    @PutMapping("/{clienteID}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long clienteID, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.actualizarCliente(clienteID, cliente);
        if (clienteActualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
    }

    // Eliminar un cliente (DELETE)
    @DeleteMapping("/{clienteID}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long clienteID) {
        boolean eliminado = clienteService.eliminarCliente(clienteID);
        if (!eliminado) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Código 204, sin contenido en la respuesta
    }
}
