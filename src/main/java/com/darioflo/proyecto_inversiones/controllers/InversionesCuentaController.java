package com.darioflo.proyecto_inversiones.controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.services.InversionesCuentaService;
import com.darioflo.proyecto_inversiones.services.DTO.InversionAltaDTO;
import com.darioflo.proyecto_inversiones.services.impl.InversionAltaServiceImpl;
import com.darioflo.proyecto_inversiones.services.impl.InversionConsultaImpl;
import com.darioflo.proyecto_inversiones.services.impl.InversionModificacionImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inversionesCuentas")
public class InversionesCuentaController {
    

    @Autowired
    InversionesCuentaService inversionesCuentaService;

    @Autowired
    InversionAltaServiceImpl inversionAltaServiceImpl;

    @Autowired
    InversionConsultaImpl inversionConsultaImpl;

    @Autowired
    InversionModificacionImpl inversionModificacionImpl;

    @GetMapping()
    public ArrayList<InversionesCuentaModel> obtenerInversionesCuentas() {
        return inversionConsultaImpl.obtenerInversionesCuentas();
    }
    
    @PostMapping()
    public InversionesCuentaModel crearInversionCuenta(@RequestBody InversionAltaDTO nuevaInversion){
        return inversionAltaServiceImpl.crearInversionCuenta(nuevaInversion);
    }

    @PutMapping("editar/{id}")
    public InversionesCuentaModel editarInversionCuenta(@PathVariable String id, @RequestBody InversionAltaDTO nuevaInversion) {
        return inversionModificacionImpl.editarInversionCuenta(id, nuevaInversion);
    }
    
    @DeleteMapping("eliminarInvCuenta/{id}")
    public void eliminarInversionCuenta(@PathVariable String id){
        inversionesCuentaService.eliminarInversionCuenta(id);
    }
}   
