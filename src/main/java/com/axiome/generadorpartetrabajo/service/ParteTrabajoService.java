package com.axiome.generadorpartetrabajo.service;

import com.axiome.generadorpartetrabajo.entity.ParteTrabajo;
import com.axiome.generadorpartetrabajo.repository.ParteTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParteTrabajoService {

    @Autowired
    private ParteTrabajoRepository parteTrabajoRepository;

    public ParteTrabajo crearParteTrabajo(ParteTrabajo parteTrabajo) {
        return parteTrabajoRepository.save(parteTrabajo);  // Guarda el parte de trabajo
    }

    public ParteTrabajo obtenerParteTrabajo(Long parteID) {
        return parteTrabajoRepository.findById(parteID).orElse(null);  // Obtiene el parte de trabajo por su ID
    }

    // Otros métodos personalizados si es necesario
}
