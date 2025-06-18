package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        ContratoModel contrato = contratoRepository.findByIdContrato(id);
        if (contrato == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrato no encontrado");
    }
    return contrato;
}

    public ContratoModel obtenerContratoPorIDCuenta(String id){
        ContratoModel contrato = contratoRepository.findByIdCuenta(id);
        if (contrato == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrato no encontrado");
        }
        return contrato;
    }
}
