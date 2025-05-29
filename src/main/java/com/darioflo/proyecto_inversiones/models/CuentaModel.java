package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuentas")
public class CuentaModel {

    @Id
    private String id; // Este será el _id generado por MongoDB

    private String idCuenta;     // Este es tu identificador de negocio
    private String idCliente;
    private Integer saldo;

    public CuentaModel() {}

    public CuentaModel(String idCuenta, String idCliente, Integer saldo) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
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
}
