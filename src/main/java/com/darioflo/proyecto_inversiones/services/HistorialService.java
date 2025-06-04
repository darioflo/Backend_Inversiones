package com.darioflo.proyecto_inversiones.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.HistorialModel;
import com.darioflo.proyecto_inversiones.repositories.HistorialRepository;

@Service
public class HistorialService {
    
    @Autowired
    HistorialRepository historialRepository;

    public HistorialModel agregarInversionAlHistorial(HistorialModel inversion){
        return historialRepository.save(inversion);
    }
}
