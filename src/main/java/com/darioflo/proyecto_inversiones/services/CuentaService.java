package com.darioflo.proyecto_inversiones.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return cuentaRepository.findByIdCuenta(id);
    }
    public ArrayList<CuentaModel> obtenerCuentasCliente(String id){
        return cuentaRepository.findByIdCliente(id);
    }

    public CuentaModel actualizarSaldo(String idCuenta,Integer nuevoSaldo){
        CuentaModel cuenta = cuentaRepository.findByIdCuenta(idCuenta);
        if (cuenta!= null) {
            cuenta.setSaldoCuenta(nuevoSaldo);
            return cuentaRepository.save(cuenta);
        }
        return null;
    }

}
