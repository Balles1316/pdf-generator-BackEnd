package com.axiome.generadorpartetrabajo.service;

import com.axiome.generadorpartetrabajo.entity.Tecnico;
import com.axiome.generadorpartetrabajo.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico crearTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);  // Guarda el técnico
    }

    public Tecnico obtenerTecnico(Long tecnicoID) {
        return tecnicoRepository.findById(tecnicoID).orElse(null);  // Obtiene el técnico por su ID
    }

    // Otros métodos personalizados si es necesario
}
