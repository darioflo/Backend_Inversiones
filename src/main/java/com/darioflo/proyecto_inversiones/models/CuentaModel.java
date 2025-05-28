package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cuentas")

public class CuentaModel {
    @Id
    private String idCuenta;
    private String idCliente;
    private Integer saldo;

    public CuentaModel (String idCliente, Integer saldo){
        this.idCliente = idCliente; 
        this.saldo = saldo;
    }

    public String getIdCuenta(){
        return this.idCuenta;
    }

    public String getIdCliente(){
        return this.idCliente;
    }

    public Integer getSaldoCuenta(){
        return this.saldo;
    }
    public void setSaldoCuenta(Integer nuevoSaldo){
        this.saldo = nuevoSaldo;
    }
}
