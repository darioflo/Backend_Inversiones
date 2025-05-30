package com.darioflo.proyecto_inversiones.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inversionesCuentas")
public class InversionesCuentaModel {

    @Id
    private String idInversionCuenta;

    private IdCuenta idCuenta;
    private IdInversion idInversion;//
    private boolean estaActiva;
    private int plazo;
    private double tasa;
    private double rendimientoAnual;
    private double saldoInicial;
    private double saldoAlTermino;
    private String instruccionVencimiento;

    // Getters y setters

    public String getIdInversionCuenta() {
        return idInversionCuenta;
    }

    public void setIdInversionCuenta(String idInversionCuenta) {
        this.idInversionCuenta = idInversionCuenta;
    }

    public IdCuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(IdCuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    public IdInversion getIdInversion() {
        return idInversion;
    }

    public void setIdInversion(IdInversion idInversion) {
        this.idInversion = idInversion;
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

    // Clases internas para idCuenta y idInversion
    public static class IdCuenta {
    private String id;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}

    public static class IdInversion {
        private String idInversion;

        public String getIdInversion() {
            return idInversion;
        }

        public void setIdInversion(String idInversion) {
            this.idInversion = idInversion;
        }
    }
}