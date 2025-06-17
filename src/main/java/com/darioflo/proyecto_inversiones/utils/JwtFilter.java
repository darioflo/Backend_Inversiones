package com.darioflo.proyecto_inversiones.utils;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter implements Filter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest solicitud = (HttpServletRequest) req;
        HttpServletResponse respuesta = (HttpServletResponse) res;

        String ruta = solicitud.getRequestURI();

        // Rutas públicas que no requieren token
        if (ruta.startsWith("/api/auth") || ruta.startsWith("/usuarios")) {
            chain.doFilter(req, res);
            return;
        }

        String cabecera = solicitud.getHeader("Authorization");
        if (cabecera == null || !cabecera.startsWith("Bearer ")) {
            respuesta.sendError(HttpStatus.UNAUTHORIZED.value(), "Falta token");
            return;
        }

        String token = cabecera.substring(7);
        if (!jwtUtil.validarToken(token)) {
            respuesta.sendError(HttpStatus.UNAUTHORIZED.value(), "Token inválido");
            return;
        }

        // Token válido → continuar
        chain.doFilter(req, res);
    }
}
