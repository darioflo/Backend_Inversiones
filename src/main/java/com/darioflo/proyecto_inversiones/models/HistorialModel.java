package com.darioflo.proyecto_inversiones.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historialInversiones")
public class HistorialModel {
     @Id
    private String idInversionCuenta;

    private Cuenta cuenta;
    private Inversion Inversion;//
    private boolean estaActiva;
    private int plazo;
    private double tasa;
    private double rendimientoAnual;
    private double saldoInicial;
    private double saldoAlTermino;
    private String instruccionVencimiento;
    private String fechaInicio;
    private String fechaFin;



    public String getIdInversionCuenta() {
        return idInversionCuenta;
    }

    public void setIdInversionCuenta(String idInversionCuenta) {
        this.idInversionCuenta = idInversionCuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta nuevaCuenta) {
        this.cuenta = nuevaCuenta;
    }

    public Inversion getInversion() {
        return Inversion;
    }

    public void setInversion(Inversion Inversion) {
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

    // Sublases internas para idCuenta y idInversion
    public static class Cuenta {
    private String id;
    private String numeroCuenta;
    private Integer saldo;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String nuevoNumeroCuenta) { this.numeroCuenta = nuevoNumeroCuenta; }
    
    public Integer getSaldo() { return saldo; }
    public void setSaldo(Integer nuevoSaldo) { this.saldo = nuevoSaldo; }
}

    public static class Inversion {
        private String idInversion;
        private String nombre;

        public String getIdInversion() {
            return idInversion;
        }

        public void setIdInversion(String idInversion) {
            this.idInversion = idInversion;
        }

        public String getNombre(){
            return nombre;
        }

        public void setNombre(String nuevoNombre){
            this.nombre = nuevoNombre;
        }
    }
}
