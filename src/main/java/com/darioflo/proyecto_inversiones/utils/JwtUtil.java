package com.darioflo.proyecto_inversiones.utils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    
    @Value("${jws.secret}")
    private String SECRET_KEY;

    private Claims extraerTodasClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public <T> T extraerClaim(String token, Function<Claims, T> claimsResolver){
        Claims claims = extraerTodasClaims(token);
        return claimsResolver.apply(claims);
    }

    public String obtenerNombreUsuario(String token){
        return extraerClaim(token, Claims::getSubject);
    }

    public Date obtenerFechaExpiracion(String token){
        return extraerClaim(token, Claims::getExpiration);
    }

    public String crearToken(Map<String,Object> claims, String nombreUsuario){
        return Jwts.builder()
        .setClaims(claims)
        .setSubject(nombreUsuario)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
    }

    public String generarToken(String nombreUsuario){
        Map<String, Object> claims = new HashMap<>();
        return crearToken(claims, nombreUsuario);
    }

    public boolean tokenExpirado(String token){
         return obtenerFechaExpiracion(token).before(new Date());
    }

    public boolean validarToken(String token, String nombreUsuario){
        final String nombreUsuarioDeToken = obtenerNombreUsuario(token);
        return (nombreUsuario.equals(nombreUsuarioDeToken) && !tokenExpirado(nombreUsuarioDeToken));
    }
}

