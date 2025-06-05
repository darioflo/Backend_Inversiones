package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

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

    public ArrayList<HistorialModel> obtenerInversionesHistorial(){
        return (ArrayList<HistorialModel>) historialRepository.findAll();
    }

    public void limpiarHistorial (){
        historialRepository.deleteAll();
    }
}
