package com.darioflo.proyecto_inversiones.utils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.darioflo.proyecto_inversiones.models.UsuarioModel;
import com.darioflo.proyecto_inversiones.services.UsuarioService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class JwtFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired 
    private UsuarioService usuarioService;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,FilterChain chain)
    throws ServletException, IOException {

        final String headerAutorizacion = request.getHeader("Authorization");
        String nombreUsuario = null;
        String jwt = null;

        if (headerAutorizacion != null && headerAutorizacion.startsWith("Bearer ")) {
            jwt = headerAutorizacion.substring(7);
            nombreUsuario = jwtUtil.obtenerNombreUsuario(jwt);
        }

        if (headerAutorizacion != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UsuarioModel usuario = usuarioService.obtenerPorNombreUsuario(nombreUsuario);


            if(jwtUtil.validarToken(jwt, usuario.getNombreUsuario())){
                UsernamePasswordAuthenticationToken tokenAutenticacion = new UsernamePasswordAuthenticationToken(jwt, usuario);
                
                tokenAutenticacion.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(tokenAutenticacion);
            }
        }

        chain.doFilter(request, response);

    }
    
}
