package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.darioflo.proyecto_inversiones.models.CuentaModel;
import com.darioflo.proyecto_inversiones.repositories.CuentaRepository;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    public ArrayList<CuentaModel> obtenerCuentas(){
        return (ArrayList<CuentaModel>) cuentaRepository.findAll();
    }
    public CuentaModel obtenerCuentaPorID(String id){
        return cuentaRepository.findById(id)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cuenta no encontrada"));
    }

    public ArrayList<CuentaModel> obtenerCuentasCliente(String id){
        ArrayList<CuentaModel> cuentas = cuentaRepository.findByIdCliente(id);
        if (cuentas.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existen cuentas para ese id");
        }
        return cuentas;
    }

    public CuentaModel actualizarSaldo(String id,Integer nuevoSaldo){
        Optional<CuentaModel> cuenta = cuentaRepository.findById(id);
        if (cuenta.isPresent()) {
            CuentaModel cuentaActual = cuenta.get();
            cuentaActual.setSaldo(nuevoSaldo);
            return cuentaRepository.save(cuentaActual);
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cuenta no encontrada");
        }

    public String generarNumeroCuenta(String tipoCuenta){
            String prefijo = tipoCuenta.toLowerCase();
            switch (prefijo) {
                case "ahorro":
                    prefijo = "AH";
                    break;
                case "inversión":
                    prefijo = "INV";
                    break;
                case "corriente":
                    prefijo = "CO";
                    break;
                default:
                    prefijo = "GEN";
            }

        long total = cuentaRepository.count();
        return prefijo +"-"+ String.format("%05d", total+1);
    }

    public CuentaModel crearCuenta(String idCliente, Integer saldo, String tipoCuenta) {
        if (idCliente == null || idCliente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de cliente requerido");
        }
        if (saldo == null || saldo < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo inválido");
        }
        String nuevoNumeroCuenta = generarNumeroCuenta(tipoCuenta);
        CuentaModel nuevaCuenta = new CuentaModel(idCliente, saldo, tipoCuenta, nuevoNumeroCuenta);
        return cuentaRepository.save(nuevaCuenta);
    }
    
}
