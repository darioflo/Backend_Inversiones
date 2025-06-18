package com.darioflo.proyecto_inversiones.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.darioflo.proyecto_inversiones.models.InversionesModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesRepository;

@Service
public class InversionesService {
    @Autowired
    InversionesRepository inversionesRepository;

    public ArrayList<InversionesModel> obtenerInversiones() {
        ArrayList<InversionesModel> inversiones = (ArrayList<InversionesModel>) inversionesRepository.findAll();
        if (inversiones.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay inversiones registradas");
        }
        return inversiones;
    }

    public InversionesModel obtenerInversionPorID(String id) {
        InversionesModel inversion = inversionesRepository.findByIdInversion(id);
        if (inversion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inversión no encontrada");
        }
        return inversion;
    }

    public InversionesModel obtenerInversionPorNombre(String nombre) {
        InversionesModel inversion = inversionesRepository.findByNombre(nombre);
        if (inversion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inversión no encontrada con ese nombre");
        }
        return inversion;
    }
}
