package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.ContratoModel;
import com.darioflo.proyecto_inversiones.repositories.ContratoRepository;


@Service
public class ContratoService {
    @Autowired
    ContratoRepository contratoRepository;

    public ArrayList<ContratoModel> obtenerContratos(){
        return (ArrayList<ContratoModel>) contratoRepository.findAll();
    }

    public ContratoModel obtenerContratoPorID(String id){
        return contratoRepository.findByIdContrato(id);
    }

       public ContratoModel obtenerContratoPorIDCuenta(String id){
        return contratoRepository.findByIdCuenta(id);
    }
}
