package com.darioflo.proyecto_inversiones.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.*;
import com.darioflo.proyecto_inversiones.models.helpers.CuentaHelpModel;
import com.darioflo.proyecto_inversiones.models.helpers.InversionHelpModel;
import com.darioflo.proyecto_inversiones.services.*;
import com.darioflo.proyecto_inversiones.repositories.InversionesCuentaRepository;
import com.darioflo.proyecto_inversiones.services.DTO.InversionAltaDTO;
import com.darioflo.proyecto_inversiones.services.interfaces.IInversionAltaService;

@Service
public class InversionAltaServiceImpl implements IInversionAltaService{
    
    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private InversionesService inversionesService;

    @Autowired
    private InversionesCuentaRepository inversionesCuentaRepository;

    @Override
    public InversionesCuentaModel crearInversion(InversionAltaDTO datosRecibidos){

        CuentaModel cuenta = cuentaService.obtenerCuentaPorID(datosRecibidos.getIdCuenta()).orElseThrow();
        
        CuentaHelpModel cuentaInversion = new CuentaHelpModel();
        cuentaInversion.setId(cuenta.getId());
        cuentaInversion.setNumeroCuenta(cuenta.getNumeroCuenta());
        cuentaInversion.setSaldo(cuenta.getSaldo());

        InversionesModel inversion = inversionesService.obtenerInversionPorID(datosRecibidos.getIdInversion());
        
        InversionHelpModel inversionDatos = new InversionHelpModel();
        inversionDatos.setIdInversion(inversion.getIdInversion());
        inversionDatos.setNombre(inversion.getNombre());

        if (cuenta.getSaldo() < datosRecibidos.getSaldoInicial()) {
             throw new IllegalArgumentException("Saldo insuficiente en la cuenta.");
        }

        InversionesCuentaModel nueva = new InversionesCuentaModel();
        nueva.setCuenta(cuentaInversion);
        nueva.setInversion(inversionDatos);
        nueva.setSaldoInicial(datosRecibidos.getSaldoInicial());
        nueva.setSaldoAlTermino(0.0); 
        nueva.setPlazo(datosRecibidos.getPlazo());
        nueva.setTasa(datosRecibidos.getTasa());
        nueva.setRendimientoAnual(datosRecibidos.getRendimientoAnual());
        nueva.setInstruccionVencimiento(datosRecibidos.getInstruccionVencimiento());
        nueva.setFechaInicio(datosRecibidos.getFechaInicio());
        nueva.setFechaFin(datosRecibidos.getFechaFin());
        nueva.setEstaActiva(true);

        cuentaService.actualizarSaldo(cuenta.getId(), cuenta.getSaldo() - datosRecibidos.getSaldoInicial().intValue());

        return inversionesCuentaRepository.save(nueva);
    }

}
