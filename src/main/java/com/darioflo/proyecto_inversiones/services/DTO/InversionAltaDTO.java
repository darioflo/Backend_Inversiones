package com.darioflo.proyecto_inversiones.services.DTO;


public class InversionAltaDTO {
    
    private String idCuenta;
    private String idInversion;
    private Double saldoInicial;
    private int plazo;
    private String instruccionVencimiento;
    private Double tasa;
    private Double rendimientoAnual;
    private String fechaInicio;
    private String fechaFin;

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

    public Double getTasa() { return tasa; }
    public void setTasa(Double tasa) { this.tasa = tasa; }

    public Double getRendimientoAnual() { return rendimientoAnual; }
    public void setRendimientoAnual(Double rendimientoAnual) { this.rendimientoAnual = rendimientoAnual; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin;}
}