package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.darioflo.proyecto_inversiones.models.HistorialModel;
import com.darioflo.proyecto_inversiones.repositories.HistorialRepository;

@Service
public class HistorialService {
    
    @Autowired
    HistorialRepository historialRepository;

    public HistorialModel agregarInversionAlHistorial(HistorialModel inversion) {
        if (inversion == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La inversión no puede ser nula");
        }
        java.time.LocalDate hoy = java.time.LocalDate.now();
        String fechaActual = String.format("%02d/%02d/%04d", hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear());
        inversion.setFechaFin(fechaActual);
        return historialRepository.save(inversion);
    }

    public ArrayList<HistorialModel> obtenerInversionesHistorial() {
        ArrayList<HistorialModel> historial = (ArrayList<HistorialModel>) historialRepository.findAll();
        if (historial.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay inversiones en el historial");
        }
        return historial;
    }

    public void limpiarHistorial (){
        historialRepository.deleteAll();
    }
}
