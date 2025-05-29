package com.darioflo.proyecto_inversiones.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darioflo.proyecto_inversiones.models.InversionesModel;
import com.darioflo.proyecto_inversiones.services.InversionesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inversiones")
public class InversionesController {
    
    @Autowired
    InversionesService inversionesService;

    @GetMapping()
    public ArrayList<InversionesModel> obtenerInversiones() {
        return inversionesService.obtenerInversiones();
    }

    @GetMapping("/{id}")
    public InversionesModel obtenerInversionPorID(@PathVariable("id") String id){
        return inversionesService.obtenerInversionPorID(id);
    }
    
}
