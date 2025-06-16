package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Document(collection = "contratos")
@Data
public class ContratoModel {
    @Id
    private String idContrato;
    private String idCuenta;
    private String tipoContrato;

    public ContratoModel (String idCuenta, String tipoContrato){
        this.idCuenta = idCuenta;
        this.tipoContrato = tipoContrato;
    }
}
