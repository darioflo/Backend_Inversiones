package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "inversiones")
@Data
public class InversionesModel {
    @Id
    private String idInversion;
    private String nombre;
    private String descripcion;

}
