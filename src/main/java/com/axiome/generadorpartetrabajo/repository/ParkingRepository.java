package com.axiome.generadorpartetrabajo.repository;

import com.axiome.generadorpartetrabajo.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
