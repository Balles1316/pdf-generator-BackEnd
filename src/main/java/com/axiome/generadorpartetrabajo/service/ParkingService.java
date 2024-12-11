package com.axiome.generadorpartetrabajo.service;

import com.axiome.generadorpartetrabajo.entity.Parking;
import com.axiome.generadorpartetrabajo.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public Parking crearParking(Parking parking) {
        return parkingRepository.save(parking);  // Guarda el parking
    }

    public Parking obtenerParking(Long parkingID) {
        return parkingRepository.findById(parkingID).orElse(null);  // Obtiene un parking por su ID
    }

    // Otros métodos personalizados si es necesario
}
