package com.axiome.generadorpartetrabajo.repository;

import com.axiome.generadorpartetrabajo.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
