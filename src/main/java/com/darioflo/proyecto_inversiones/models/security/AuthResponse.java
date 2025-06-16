package com.darioflo.proyecto_inversiones.models.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    
    private String jwt;
}
