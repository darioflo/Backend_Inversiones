package com.darioflo.proyecto_inversiones.models;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "usuarios")
public class UsuarioModel {

    public String id;
    public String idCliente;
    public String nombreUsuario;
    public String clave;
    public String rol;
    
}
