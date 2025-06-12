package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.darioflo.proyecto_inversiones.models.helpers.CuentaHelpModel;
import com.darioflo.proyecto_inversiones.models.helpers.InversionHelpModel;

@Document(collection = "inversionesCuentas")
public class InversionesCuentaModel {

    @Id
    private String idInversionCuenta;

    private CuentaHelpModel cuenta;
    private InversionHelpModel Inversion;//
    private boolean estaActiva;
    private int plazo;
    private double tasa;
    private double rendimientoAnual;
    private double saldoInicial;
    private double saldoAlTermino;
    private String instruccionVencimiento;
    private String fechaInicio;
    private String fechaFin;

    // Getters y setters

    public String getIdInversionCuenta() {
        return idInversionCuenta;
    }

    public void setIdInversionCuenta(String idInversionCuenta) {
        this.idInversionCuenta = idInversionCuenta;
    }

    public CuentaHelpModel getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaHelpModel nuevaCuenta) {
        this.cuenta = nuevaCuenta;
    }

    public InversionHelpModel getInversion() {
        return Inversion;
    }

    public void setInversion(InversionHelpModel Inversion) {
        this.Inversion = Inversion;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getRendimientoAnual() {
        return rendimientoAnual;
    }

    public void setRendimientoAnual(double rendimientoAnual) {
        this.rendimientoAnual = rendimientoAnual;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoAlTermino() {
        return saldoAlTermino;
    }

    public void setSaldoAlTermino(double saldoAlTermino) {
        this.saldoAlTermino = saldoAlTermino;
    }

    public String getInstruccionVencimiento() {
        return instruccionVencimiento;
    }

    public void setInstruccionVencimiento(String instruccionVencimiento) {
        this.instruccionVencimiento = instruccionVencimiento;
    }

    public String getFechaInicio(){
        return this.fechaInicio;
    }

    public void setFechaInicio( String nuevaFecha){
        this.fechaInicio = nuevaFecha;
    }
    
    public String getFechaFin(){
        return this.fechaFin;
    }

    public void setFechaFin( String nuevaFecha){
        this.fechaFin = nuevaFecha;
    }

}