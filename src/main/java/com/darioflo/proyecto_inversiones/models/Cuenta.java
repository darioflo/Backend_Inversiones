package com.darioflo.proyecto_inversiones.models;

public class Cuenta {
    private String idCuenta;
    private String idCliente;
    private Integer saldo;

    public Cuenta (String idCliente, Integer saldo){
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
