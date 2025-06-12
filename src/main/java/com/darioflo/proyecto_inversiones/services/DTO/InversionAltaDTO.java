package com.darioflo.proyecto_inversiones.services.DTO;

import com.darioflo.proyecto_inversiones.models.helpers.CuentaHelpModel;
import com.darioflo.proyecto_inversiones.models.helpers.InversionHelpModel;

public class InversionAltaDTO {
    
    private String idInversionCuenta;
    private CuentaHelpModel cuenta;
    private InversionHelpModel Inversion;
    private Double saldoInicial;
    private int plazo;
    private String instruccionVencimiento;
    private Double tasa;
    private Double rendimientoAnual;
    private String fechaInicio;
    private String fechaFin;
     private boolean estaActiva;

    public String getIdInversionCuenta() { return idInversionCuenta; }
    public void setIdInversionCuenta(String idInversionCuenta) { this.idInversionCuenta = idInversionCuenta; }

    public CuentaHelpModel getCuenta() { return cuenta; }
    public void setCuenta(CuentaHelpModel nuevaCuenta) { this.cuenta = nuevaCuenta; }

    public InversionHelpModel getInversion() { return Inversion; }
    public void setInversion(InversionHelpModel Inversion) { this.Inversion = Inversion;}

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

    public boolean isEstaActiva() { return estaActiva; }
    public void setEstaActiva(boolean estaActiva) { this.estaActiva = estaActiva; }
}