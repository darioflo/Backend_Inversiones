package com.darioflo.proyecto_inversiones.services.impl;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesCuentaRepository;
import com.darioflo.proyecto_inversiones.services.interfaces.IInversionConsultaService;


@Service
public class InversionConsultaImpl  implements IInversionConsultaService{

    private static final Logger logger = LoggerFactory.getLogger(InversionConsultaImpl.class);
     
    @Autowired
    private InversionesCuentaRepository inversionesCuentaRepository;

    public ArrayList<InversionesCuentaModel> obtenerInversionesCuentas(){
        logger.info("Consulta de inversiones iniciada");

        ArrayList<InversionesCuentaModel> inversiones = (ArrayList<InversionesCuentaModel>) inversionesCuentaRepository.findAll();

         logger.info("Consulta de inversiones terminada, se encontraron: " + inversiones.size());

         return inversiones;
    }
}
