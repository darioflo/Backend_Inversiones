package com.darioflo.proyecto_inversiones.controllers;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darioflo.proyecto_inversiones.models.CuentaModel;
import com.darioflo.proyecto_inversiones.services.CuentaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    CuentaService cuentaService;

    @GetMapping()
    public ArrayList<CuentaModel> obtenerCuentas() {
        return cuentaService.obtenerCuentas();
    }
    @GetMapping("/{idCuenta}")
    public Optional<CuentaModel> obtenerCuentaPorId(@PathVariable("idCuenta") String id) {
        return cuentaService.obtenerCuentaPorID(id);
    }
    @GetMapping("/cuentasCliente/{idCliente}")
    public ArrayList<CuentaModel> obtenerCuentasCliente(@PathVariable("idCliente") String id) {
        return cuentaService.obtenerCuentasCliente(id);
    }
    @PutMapping("/{idCuenta}/saldo")
    public CuentaModel actualizarSaldo(@PathVariable("idCuenta") String idCuenta, @RequestBody Integer nuevoSaldo){
        return cuentaService.actualizarSaldo(idCuenta, nuevoSaldo);
    } 

    @PostMapping()
    public CuentaModel crearCuentaNueva(@RequestBody CuentaModel cuentaModel) {
        return cuentaService.crearCuenta( cuentaModel.getIdCliente(), cuentaModel.getSaldo(),cuentaModel.getTipoCuenta()
    );
}
}
