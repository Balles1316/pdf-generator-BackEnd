package com.axiome.generadorpartetrabajo.service;

import com.axiome.generadorpartetrabajo.entity.Incidencia;
import com.axiome.generadorpartetrabajo.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    // Crear una incidencia
    public Incidencia crearIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);  // Guarda la incidencia
    }

    // Obtener una incidencia por su ID
    public Incidencia obtenerIncidencia(Long incidenciaID) {
        return incidenciaRepository.findById(incidenciaID).orElse(null);  // Obtiene una incidencia por su ID
    }

    // Obtener todas las incidencias
    public List<Incidencia> obtenerTodasLasIncidencias() {
        return incidenciaRepository.findAll();
    }

    // Actualizar una incidencia por su ID
    public Incidencia actualizarIncidencia(Long incidenciaID, Incidencia incidencia) {
        Optional<Incidencia> incidenciaExistente = incidenciaRepository.findById(incidenciaID);

        if (incidenciaExistente.isPresent()) {
            Incidencia incidenciaActualizada = incidenciaExistente.get();
            // Actualiza los campos que desees
            incidenciaActualizada.setFechaIncidencia(incidencia.getFechaIncidencia());
            incidenciaActualizada.setDescripcionIncidencia(incidencia.getDescripcionIncidencia());
            incidenciaActualizada.setEstado(incidencia.getEstado());
            incidenciaActualizada.setParking(incidencia.getParking());

            return incidenciaRepository.save(incidenciaActualizada);  // Guarda los cambios
        }
        return null;  // Si la incidencia no existe, retorna null
    }

    // Eliminar una incidencia y retornar true si se eliminó exitosamente
    public boolean eliminarIncidencia(Long incidenciaID) {
        if (incidenciaRepository.existsById(incidenciaID)) {
            incidenciaRepository.deleteById(incidenciaID);
            return true;  // Se eliminó exitosamente
        }
        return false;  // No se encontró la incidencia
    }
}
