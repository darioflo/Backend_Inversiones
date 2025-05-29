package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuentas")
public class CuentaModel {

    @Id
    private String id;         
    private String idCliente;
    private Integer saldo;

    public CuentaModel() {}

    public CuentaModel(String idCliente, Integer saldo) {
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getSaldoCuenta() {
        return saldo;
    }

    public void setSaldoCuenta(Integer nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
}