package com.darioflo.proyecto_inversiones.services.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesCuentaRepository;
import com.darioflo.proyecto_inversiones.services.interfaces.IInversionConsultaService;

public class InversionConsultaImpl  implements IInversionConsultaService{

    private static final Logger logger = LoggerFactory.getLogger(InversionConsultaImpl.class);
     
    @Autowired
    private InversionesCuentaRepository inversionesCuentaRepository;

    public List<InversionesCuentaModel> obtenerInversiones(){
        logger.info("Consulta de inversiones iniciada");

        List<InversionesCuentaModel> inversiones = (List<InversionesCuentaModel>) inversionesCuentaRepository.findAll();

         logger.info("Consulta de inversiones terminada, se encontraron: " + inversiones.size());

         return inversiones;
    }
}
