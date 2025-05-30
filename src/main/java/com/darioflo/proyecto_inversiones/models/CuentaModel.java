package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuentas")
public class CuentaModel {

    @Id
    private String idCuenta; // Este será el _id generado por MongoDB
    private String idCliente;
    private Integer saldo;
    private String tipoCuenta;

    public CuentaModel() {}

    public CuentaModel(String idCuenta, String idCliente, Integer saldo) {
        this.idCliente = idCliente;
        this.saldo = saldo;
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
}
