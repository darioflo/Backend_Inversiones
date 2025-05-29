package com.darioflo.proyecto_inversiones.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.InversionesModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesRepository;

@Service
public class InversionesService {
    @Autowired
    InversionesRepository inversionesRepository;

    public ArrayList<InversionesModel> obtenerInversiones(){
        return (ArrayList<InversionesModel>) inversionesRepository.findAll();
    }

    public InversionesModel obtenerInversionPorID(String id){
        return inversionesRepository.findByIdInversion(id);
    }

        public InversionesModel obtenerInversionPorNombre(String nombre){
        return inversionesRepository.findByNombre(nombre);
    }
}
