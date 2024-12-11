package com.axiome.generadorpartetrabajo.repository;

import com.axiome.generadorpartetrabajo.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}
