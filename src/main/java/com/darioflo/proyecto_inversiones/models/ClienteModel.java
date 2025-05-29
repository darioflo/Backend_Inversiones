package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "clientes")
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



    public String getIdCliente(){
        return this.idCliente;
    }

    public void setNombre(String nombreNuevo){
        this.nombre = nombreNuevo;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setApellidoPaterno(String apellidoNuevo){
        this.apellidoPaterno = apellidoNuevo;
    }

    public String getApellidoPaterno(){
        return this.apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoNuevo){
        this.apellidoMaterno = apellidoNuevo;
    }
    
    public String getApellidoMaterno(){
        return this.apellidoMaterno;
    }

    public void setDireccion(String nuevaDireccion){
        this.direccion = nuevaDireccion;
    }
    public String getDireccion(){
        return this.direccion;
    }
}
