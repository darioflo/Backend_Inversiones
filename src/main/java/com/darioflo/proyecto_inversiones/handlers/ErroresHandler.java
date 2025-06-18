package com.darioflo.proyecto_inversiones.handlers;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ErroresHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> ErrorDelServidor500(Exception excepcion){
        Map<String,Object> objetoError = new HashMap<>();
        objetoError.put("fecha", LocalDateTime.now());
        objetoError.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        objetoError.put("error","Error interno del servidor");
        objetoError.put("mensaje",excepcion.getMessage());

        return new ResponseEntity<>(objetoError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<Object> ErrorDeSolicitudIncorrecta400(Exception excepcion){
        Map<String,Object> objetoError = new HashMap<>();
        objetoError.put("fecha",LocalDateTime.now());
        objetoError.put("status",HttpStatus.BAD_REQUEST.value());
        objetoError.put("error", "Solicitud incorrecta; Compruebe los datos enviados");
        objetoError.put("mensaje",excepcion.getMessage());

        return new ResponseEntity<>(objetoError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.web.server.ResponseStatusException.class)
    public ResponseEntity<Object> ErrorNoEncontrado404(Exception excepcion){
        Map<String,Object> objetoError = new HashMap<>();
        objetoError.put("fecha", LocalDateTime.now());
        objetoError.put("status", HttpStatus.NOT_FOUND.value());
        objetoError.put("error","Recurso no encontrado");
        objetoError.put("mensaje",excepcion.getMessage() );

        return new ResponseEntity<>(objetoError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
    public ResponseEntity<Object> ErrorAccesoDenegado403(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("fecha", LocalDateTime.now());
        error.put("status", HttpStatus.FORBIDDEN.value());
        error.put("error", "Acceso denegado");
        error.put("mensaje", ex.getMessage());
        
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    
    }

    @ExceptionHandler(org.springframework.security.authentication.BadCredentialsException.class)
    public ResponseEntity<Object> ErrorNoAutorizado401(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("fecha", LocalDateTime.now());
        error.put("status", HttpStatus.UNAUTHORIZED.value());
        error.put("error", "No autorizado");
        error.put("mensaje", ex.getMessage());
        
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Object> ErrorDeValidacion422(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("fecha", LocalDateTime.now());
        error.put("status", 422);
        error.put("error", "Error de validación");
        error.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);

    }

}
