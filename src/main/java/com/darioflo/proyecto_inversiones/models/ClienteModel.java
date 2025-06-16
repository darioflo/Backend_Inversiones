package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Document(collection = "clientes")
@Data
public class ClienteModel {
    @Id
    private String idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;



    public ClienteModel(String nombre, String apellidoPaterno, String apellidoMaterno, String direccion){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
    }

}
