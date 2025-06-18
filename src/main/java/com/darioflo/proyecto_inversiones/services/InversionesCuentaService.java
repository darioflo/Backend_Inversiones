package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.darioflo.proyecto_inversiones.models.CuentaModel;
import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;
import com.darioflo.proyecto_inversiones.repositories.InversionesCuentaRepository;


@Service
public class InversionesCuentaService {
    
    @Autowired
    InversionesCuentaRepository inversionesCuentaRepository;
    @Autowired
    CuentaService cuentaService;

   public ArrayList<InversionesCuentaModel> obtenerInversionesCuentas() {
    ArrayList<InversionesCuentaModel> inversiones = (ArrayList<InversionesCuentaModel>) inversionesCuentaRepository.findAll();
    if (inversiones.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay inversiones de cuentas registradas");
    }
    return inversiones;
}

    public InversionesCuentaModel crearInversionCuenta(InversionesCuentaModel nuevaInversion) {
        if (nuevaInversion == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La inversión no puede ser nula");
        }
        return inversionesCuentaRepository.save(nuevaInversion);
    }

    public InversionesCuentaModel editarInversionCuenta(String id, InversionesCuentaModel datosActualizados) {
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
        CuentaModel cuenta = cuentaService.obtenerCuentaPorID(idCuenta);
        if (cuenta != null) {
            Double saldoActual = cuenta.getSaldo().doubleValue();
            Double saldoFinal = saldoActual - nuevoSaldoInicial;
            if (saldoFinal >= 0) {
                cuenta.setSaldo(saldoFinal.intValue());
                cuentaService.actualizarSaldo(idCuenta, cuenta.getSaldo());
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente en la cuenta");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta asociada no encontrada");
        }

        return inversionesCuentaRepository.save(inversionExistente);
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inversión no encontrada"));
}

    public void eliminarInversionCuenta(String id) {
        if (!inversionesCuentaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inversión no encontrada para eliminar");
        }
        inversionesCuentaRepository.deleteById(id);
    }
}
