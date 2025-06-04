package com.darioflo.proyecto_inversiones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.darioflo.proyecto_inversiones.models.HistorialModel;
import com.darioflo.proyecto_inversiones.services.HistorialService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/historialInversion")
@Controller
public class HistorialController {
    
    @Autowired
    HistorialService historialService;

    @PostMapping()
    public HistorialModel agregarAlHistorial (@RequestBody HistorialModel inversion) {
        return historialService.agregarInversionAlHistorial(inversion);
    }
    
}
