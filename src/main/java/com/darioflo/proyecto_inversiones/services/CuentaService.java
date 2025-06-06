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

    public CuentaModel crearCuenta(String idCliente, Integer saldo, String tipoCuenta){
        String nuevoNumeroCuenta = generarNumeroCuenta(tipoCuenta);
        CuentaModel nuevaCuenta = new CuentaModel(idCliente,saldo,tipoCuenta,nuevoNumeroCuenta );
        return cuentaRepository.save(nuevaCuenta);
    }
}
