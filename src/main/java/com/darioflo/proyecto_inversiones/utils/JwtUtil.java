package com.darioflo.proyecto_inversiones.utils;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jws.secret}")
    private String claveSecreta;

    public String generarToken(String nombreUsuario) {
        return Jwts.builder()
                .setSubject(nombreUsuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 20))
                .signWith(SignatureAlgorithm.HS256, claveSecreta)
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(claveSecreta).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String obtenerNombreUsuario(String token) {
        return Jwts.parser().setSigningKey(claveSecreta)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
