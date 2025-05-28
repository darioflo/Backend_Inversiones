package com.darioflo.proyecto_inversiones.models;

public class Contrato {
    private String idContrato;
    private String idCuenta;
    private String tipoContrato;

    public Contrato (String idCuenta, String tipoContrato){
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
