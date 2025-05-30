package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesCuentaRepository;


@Service
public class InversionesCuentaService {
    
    @Autowired
    InversionesCuentaRepository inversionesCuentaRepository;

    public ArrayList<InversionesCuentaModel> obtenerInversionesCuentas(){
        return (ArrayList<InversionesCuentaModel>) inversionesCuentaRepository.findAll();
    }

    public InversionesCuentaModel crearInversionCuenta(InversionesCuentaModel nuevaInversion){
        return inversionesCuentaRepository.save(nuevaInversion);
    }


}
