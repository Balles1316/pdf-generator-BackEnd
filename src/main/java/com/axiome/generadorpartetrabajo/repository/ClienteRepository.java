package com.axiome.generadorpartetrabajo.repository;

import com.axiome.generadorpartetrabajo.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
