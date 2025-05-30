package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inversiones")

public class InversionesModel {
    @Id
    private String idInversion;
    private String nombre;
    private String descripcion;

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
}
