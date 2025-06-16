package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document(collection = "cuentas")
@Data
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

}
