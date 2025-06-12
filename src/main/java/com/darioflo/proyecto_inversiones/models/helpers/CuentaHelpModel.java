package com.darioflo.proyecto_inversiones.models.helpers;

public class CuentaHelpModel {
    private String id;
    private String numeroCuenta;
    private Integer saldo;

    public String getId() { 
        return id; 
    }
    public void setId(String id) { 
        this.id = id; 
    }
    
    public String getNumeroCuenta() { 
        return numeroCuenta; 
    }
    public void setNumeroCuenta(String nuevoNumeroCuenta) { 
        this.numeroCuenta = nuevoNumeroCuenta; 
    }
    
    public Integer getSaldo() { 
        return saldo; 
    }
    public void setSaldo(Integer nuevoSaldo) { 
        this.saldo = nuevoSaldo; 
    }
}

