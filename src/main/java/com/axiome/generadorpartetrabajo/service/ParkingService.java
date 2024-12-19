package com.axiome.generadorpartetrabajo.service;

import com.axiome.generadorpartetrabajo.entity.Parking;
import com.axiome.generadorpartetrabajo.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    // Crear un nuevo parking
    public Parking crearParking(Parking parking) {
        return parkingRepository.save(parking);
    }

    // Obtener todos los parkings
    public List<Parking> obtenerTodosParkings() {
        return parkingRepository.findAll();
    }

    // Obtener un parking por ID
    public Parking obtenerParking(Long parkingID) {
        Optional<Parking> optionalParking = parkingRepository.findById(parkingID);
        return optionalParking.orElse(null);
    }

    // Actualizar un parking existente
    public Parking actualizarParking(Long parkingID, Parking parkingDetalles) {
        Optional<Parking> optionalParking = parkingRepository.findById(parkingID);
        if (optionalParking.isPresent()) {
            Parking parkingExistente = optionalParking.get();
            parkingExistente.setNombre(parkingDetalles.getNombre());
            parkingExistente.setLocalidad(parkingDetalles.getLocalidad());
            parkingExistente.setProvincia(parkingDetalles.getProvincia());
            parkingExistente.setDireccion(parkingDetalles.getDireccion());
            parkingExistente.setCodigoParking(parkingDetalles.getCodigoParking());
            parkingExistente.setCliente(parkingDetalles.getCliente());
            return parkingRepository.save(parkingExistente);
        }
        return null;
    }

    // Eliminar un parking por ID
    public boolean eliminarParking(Long parkingID) {
        Optional<Parking> optionalParking = parkingRepository.findById(parkingID);
        if (optionalParking.isPresent()) {
            parkingRepository.deleteById(parkingID);
            return true;
        }
        return false;
    }
}
