package com.darioflo.proyecto_inversiones.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.darioflo.proyecto_inversiones.models.UsuarioModel;
import com.darioflo.proyecto_inversiones.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    public UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay usuarios registrados");
        }
        return usuarios;
    }

    public String agregarUsuario(UsuarioModel nuevoUsuario) {
        if (nuevoUsuario == null || nuevoUsuario.getNombreUsuario() == null || nuevoUsuario.getNombreUsuario().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos de usuario inválidos");
        }
        usuarioRepository.save(nuevoUsuario);
        return "Usuario agregado correctamente :)";
    }

    public UsuarioModel obtenerPorNombreUsuario(String nombreUsuario) {
        UsuarioModel usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        return usuario;
    }
}
