package com.darioflo.proyecto_inversiones.services.DTO;

public class InversionConsultaDTO {
    private String idCuenta;
    private String idInversion;

    
    public String getIdCuenta(){ return this.idCuenta; }
    public void setIdCuenta (String nuevoIdCuenta){ this.idCuenta = nuevoIdCuenta; }

    public String getIdInversion(){return this.idInversion; }
    public void setIdInversion(String nuevoIdInversion){ this.idInversion = nuevoIdInversion; }
}
