package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;
import java.util.Optional;

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

    public HistorialModel nuevaFechaDeEliminacion(String id) {
        Optional<HistorialModel> inversionCuenta = historialRepository.findById(id);
        if (inversionCuenta.isPresent()) {
            java.time.LocalDate hoy = java.time.LocalDate.now();
            String nuevaFecha = String.format("%02d/%02d/%04d", hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear());

            HistorialModel historial = inversionCuenta.get();
            historial.setFechaFin(nuevaFecha);
            historialRepository.save(historial);
            return historial;
        }
        return null;
    }
}
