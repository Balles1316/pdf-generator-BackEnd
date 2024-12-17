package com.axiome.generadorpartetrabajo.controller;

import com.axiome.generadorpartetrabajo.entity.Parking;
import com.axiome.generadorpartetrabajo.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkings")  // URL base para todas las operaciones de parkings
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde Angular
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    // Crear un nuevo parking (POST)
    @PostMapping
    public ResponseEntity<Parking> crearParking(@RequestBody Parking parking) {
        Parking nuevoParking = parkingService.crearParking(parking);
        return new ResponseEntity<>(nuevoParking, HttpStatus.CREATED);
    }

    // Obtener todos los parkings (GET)
    @GetMapping
    public ResponseEntity<List<Parking>> obtenerParkings() {
        List<Parking> parkings = parkingService.obtenerTodosParkings();
        return new ResponseEntity<>(parkings, HttpStatus.OK);
    }

    // Obtener un parking por ID (GET)
    @GetMapping("/{parkingID}")
    public ResponseEntity<Parking> obtenerParking(@PathVariable Long parkingID) {
        Parking parking = parkingService.obtenerParking(parkingID);
        if (parking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Si no se encuentra, devuelve un 404
        }
        return new ResponseEntity<>(parking, HttpStatus.OK);
    }

    // Actualizar un parking (PUT)
    @PutMapping("/{parkingID}")
    public ResponseEntity<Parking> actualizarParking(@PathVariable Long parkingID, @RequestBody Parking parking) {
        Parking parkingActualizado = parkingService.actualizarParking(parkingID, parking);
        if (parkingActualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(parkingActualizado, HttpStatus.OK);
    }

    // Eliminar un parking (DELETE)
    @DeleteMapping("/{parkingID}")
    public ResponseEntity<Void> eliminarParking(@PathVariable Long parkingID) {
        boolean eliminado = parkingService.eliminarParking(parkingID);
        if (!eliminado) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Código 204, sin contenido en la respuesta
    }
}