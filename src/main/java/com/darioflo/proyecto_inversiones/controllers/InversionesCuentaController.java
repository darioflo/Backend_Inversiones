package com.darioflo.proyecto_inversiones.controllers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.services.InversionesCuentaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inversionesCuentas")
public class InversionesCuentaController {
    

    @Autowired
    InversionesCuentaService inversionesCuentaService;

    @GetMapping()
    public ArrayList<InversionesCuentaModel> obtenerInversionesCuentas() {
        return inversionesCuentaService.obtenerInversionesCuentas();
    }
    

    @PostMapping()
    public InversionesCuentaModel crearInversionCuenta(@RequestBody InversionesCuentaModel nuevaInversion){
        return inversionesCuentaService.crearInversionCuenta(nuevaInversion);
    }
    

}
