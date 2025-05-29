package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inversiones")

public class InversionesModel {
    @Id
    private String idInversion;
    private String nombre;
    private String descripcion;
    private int plazo;
    private double tasa;
    private double rendimientoAnual;
    private double saldoInicial;
    private double saldoAlTermino;
    private String instruccionVencimiento;

    //constructor
    public InversionesModel( ){}
    

    public String getIdInversion() {
        return idInversion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPlazo() {
        return plazo;
    }

    public double getTasa() {
        return tasa;
    }

    public double getRendimientoAnual() {
        return rendimientoAnual;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public double getSaldoAlTermino() {
        return saldoAlTermino;
    }

    public String getInstruccionVencimiento() {
        return instruccionVencimiento;
    }

    public void setSaldoAlTermino(double saldoAlTermino) {
        this.saldoAlTermino = saldoAlTermino;
    }

    /*@Override
    public String toString() {
        return "Inversiones{" +
                "idInversion='" + idInversion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", plazo=" + plazo +
                ", tasa=" + tasa +
                ", rendimientoAnual=" + rendimientoAnual +
                ", saldoInicial=" + saldoInicial +
                ", saldoAlTermino=" + saldoAlTermino +
                ", instruccionVencimiento='" + instruccionVencimiento + '\'' +
                '}';
    }*/
}
