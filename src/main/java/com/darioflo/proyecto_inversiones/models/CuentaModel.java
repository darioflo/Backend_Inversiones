package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuentas")
public class CuentaModel {

    @Id
    private String idCuenta; 
    private String idCliente;
    private Integer saldo;
    private String tipoCuenta;
    private String numeroCuenta;

    public CuentaModel() {}

    public CuentaModel(String idCliente, Integer saldo, String tipoCuenta, String numeroCuenta) {
        this.idCliente = idCliente;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
    }

    public String getId() {
        return idCuenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
        public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    public void setNumeroCuenta(String nuevoNumeroCuenta){
        this.numeroCuenta = nuevoNumeroCuenta;
    }
}
