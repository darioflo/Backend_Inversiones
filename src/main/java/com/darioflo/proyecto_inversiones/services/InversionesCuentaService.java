package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.CuentaModel;
import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesCuentaRepository;


@Service
public class InversionesCuentaService {
    
    @Autowired
    InversionesCuentaRepository inversionesCuentaRepository;
    @Autowired
    CuentaService cuentaService;

    public ArrayList<InversionesCuentaModel> obtenerInversionesCuentas(){
        return (ArrayList<InversionesCuentaModel>) inversionesCuentaRepository.findAll();
    }

    public InversionesCuentaModel crearInversionCuenta(InversionesCuentaModel nuevaInversion){
        return inversionesCuentaRepository.save(nuevaInversion);
    }

    public InversionesCuentaModel editarInversionCuenta(String id, InversionesCuentaModel datosActualizados){
        return inversionesCuentaRepository.findById(id).map(inversionExistente -> {
        inversionExistente.setCuenta(datosActualizados.getCuenta());
        inversionExistente.setInversion(datosActualizados.getInversion());
        inversionExistente.setEstaActiva(datosActualizados.isEstaActiva());
        inversionExistente.setPlazo(datosActualizados.getPlazo());
        inversionExistente.setTasa(datosActualizados.getTasa());
        inversionExistente.setRendimientoAnual(datosActualizados.getRendimientoAnual());
        inversionExistente.setSaldoInicial(datosActualizados.getSaldoInicial());
        inversionExistente.setSaldoAlTermino(datosActualizados.getSaldoAlTermino());
        inversionExistente.setInstruccionVencimiento(datosActualizados.getInstruccionVencimiento());
        
        String idCuenta = datosActualizados.getCuenta().getIdCuenta();
        Double nuevoSaldoInicial = datosActualizados.getSaldoInicial();
        CuentaModel cuenta = cuentaService.obtenerCuentaPorID(idCuenta).orElse(null);
        if (cuenta != null) {
            Double saldoActual = cuenta.getSaldo().doubleValue();
            Double saldoFinal = saldoActual - nuevoSaldoInicial;
            if (saldoFinal >= 0) {
                cuenta.setSaldo(saldoFinal.intValue());
                cuentaService.actualizarSaldo(idCuenta, cuenta.getSaldo());
            }
        }

        return inversionesCuentaRepository.save(inversionExistente);
    }).orElse(null);
    }

    public void eliminarInversionCuenta(String id){
        inversionesCuentaRepository.deleteById(id);
    }
}
