package com.darioflo.proyecto_inversiones.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darioflo.proyecto_inversiones.models.ContratoModel;
import com.darioflo.proyecto_inversiones.services.ContratoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "*")
@RequestMapping("/contratos")
@RestController
public class ContratoController {
    
    @Autowired
    ContratoService contratoService;

    @GetMapping()
    public ArrayList<ContratoModel> obtenerContratos () {
        return contratoService.obtenerContratos();
    }
    
    @GetMapping("/{id}")
    public ContratoModel obtenerContratoPorID(@PathVariable("id") String id) {
        return contratoService.obtenerContratoPorID(id);
    }
    
}
