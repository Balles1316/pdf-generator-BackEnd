package com.axiome.generadorpartetrabajo.controller;

import com.axiome.generadorpartetrabajo.entity.Incidencia;
import com.axiome.generadorpartetrabajo.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    // Crear una nueva incidencia (POST)
    @PostMapping
    public ResponseEntity<Incidencia> crearIncidencia(@RequestBody Incidencia incidencia) {
        Incidencia nuevaIncidencia = incidenciaService.crearIncidencia(incidencia);
        return new ResponseEntity<>(nuevaIncidencia, HttpStatus.CREATED);
    }

    // Obtener todas las incidencias (GET)
    @GetMapping
    public ResponseEntity<List<Incidencia>> obtenerIncidencias() {
        List<Incidencia> incidencias = incidenciaService.obtenerTodasLasIncidencias();
        return new ResponseEntity<>(incidencias, HttpStatus.OK);
    }

    // Obtener una incidencia por ID (GET)
    @GetMapping("/{incidenciaID}")
    public ResponseEntity<Incidencia> obtenerIncidencia(@PathVariable Long incidenciaID) {
        Incidencia incidencia = incidenciaService.obtenerIncidencia(incidenciaID);
        if (incidencia == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(incidencia, HttpStatus.OK);
    }

    // Actualizar una incidencia (PUT)
    @PutMapping("/{incidenciaID}")
    public ResponseEntity<Incidencia> actualizarIncidencia(@PathVariable Long incidenciaID, @RequestBody Incidencia incidencia) {
        Incidencia incidenciaActualizada = incidenciaService.actualizarIncidencia(incidenciaID, incidencia);
        if (incidenciaActualizada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(incidenciaActualizada, HttpStatus.OK);
    }

    // Eliminar una incidencia (DELETE)
    @DeleteMapping("/{incidenciaID}")
    public ResponseEntity<Void> eliminarIncidencia(@PathVariable Long incidenciaID) {
        boolean eliminada = incidenciaService.eliminarIncidencia(incidenciaID);
        if (!eliminada) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Código 204, sin contenido en la respuesta
    }
}
