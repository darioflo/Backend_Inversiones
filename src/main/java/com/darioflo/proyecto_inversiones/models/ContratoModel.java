package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "contratos")

public class ContratoModel {
    @Id
    private String idContrato;
    private String idCuenta;
    private String tipoContrato;

    public ContratoModel (String idCuenta, String tipoContrato){
        this.idCuenta = idCuenta;
        this.tipoContrato = tipoContrato;
    }

    public String getIdContrato(){
        return this.idContrato;
    }

    public String getIdCuenta(){
        return this.idCuenta;
    }

    public String getTipoContrato(){
        return this.tipoContrato;
    }

    public void setTipoContrato(String tipoContratoNuevo){
        this.tipoContrato = tipoContratoNuevo;
    }


}
