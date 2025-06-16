package com.darioflo.proyecto_inversiones.models.security;

import lombok.Data;

@Data
public class AuthRequest {
    
    private String nombreUsuario;
    private String clave;
    
}
