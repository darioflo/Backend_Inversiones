package com.darioflo.proyecto_inversiones.services.DTO;

public class InversionModificacionDTO {
    
    private String idInversionCuenta;
    private String idCuenta;
    private String idInversion;
    private Double saldoInicial;
    private int plazo;
    private String instruccionVencimiento;

    
    public String getIdInversionCuenta() { return idInversionCuenta; }
    public void setIdInversionCuenta(String id) { this.idInversionCuenta = id; }

    public String getIdCuenta(){ return this.idCuenta; }
    public void setIdCuenta (String nuevoIdCuenta){ this.idCuenta = nuevoIdCuenta; }

    public String getIdInversion(){return this.idInversion; }
    public void setIdInversion(String nuevoIdInversion){ this.idInversion = nuevoIdInversion; }

    public Double getSaldoInicial(){ return this.saldoInicial; }
    public void setSaldoInicial(Double nuevoSaldoInicial) { this.saldoInicial = nuevoSaldoInicial; }

    public int getPlazo(){ return this.plazo; }
    public void setPlazo (int nuevoPlazo) { this.plazo = nuevoPlazo; }

    public String getInstruccionVencimiento() { return this.instruccionVencimiento; }
    public void setInstruccionVencimiento(String instruccionVencimiento) { this.instruccionVencimiento = instruccionVencimiento; }
}
