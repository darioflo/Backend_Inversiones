package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;
import java.util.Optional;

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
    public Optional<CuentaModel> obtenerCuentaPorID(String id){
        return cuentaRepository.findById(id);
    }

    public ArrayList<CuentaModel> obtenerCuentasCliente(String id){
        return cuentaRepository.findByIdCliente(id);
    }

    public CuentaModel actualizarSaldo(String id,Integer nuevoSaldo){
        Optional<CuentaModel> cuenta = cuentaRepository.findById(id);
   if (cuenta.isPresent()) {
        CuentaModel cuentaActual = cuenta.get();
        cuentaActual.setSaldo(nuevoSaldo);
        return cuentaRepository.save(cuentaActual);
    }
    return null;
    }
}
