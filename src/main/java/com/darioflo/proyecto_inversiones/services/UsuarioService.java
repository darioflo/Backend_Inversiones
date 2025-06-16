package com.darioflo.proyecto_inversiones.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darioflo.proyecto_inversiones.models.UsuarioModel;
import com.darioflo.proyecto_inversiones.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    public UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public String agregarUsuario(UsuarioModel nuevoUsuario){
        usuarioRepository.save(nuevoUsuario);
        return "Usuario agregado correctamente :)";
    }

    public UsuarioModel obtenerPorNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
}
