package com.axiome.generadorpartetrabajo.repository;

import com.axiome.generadorpartetrabajo.entity.ParteTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParteTrabajoRepository extends JpaRepository<ParteTrabajo, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
