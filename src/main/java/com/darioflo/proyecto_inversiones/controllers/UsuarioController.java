package com.darioflo.proyecto_inversiones.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darioflo.proyecto_inversiones.models.UsuarioModel;
import com.darioflo.proyecto_inversiones.services.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }
    
    @PostMapping()
    public String postMethodName(@RequestBody UsuarioModel usuarioNuevo) {
        return usuarioService.agregarUsuario(usuarioNuevo);
    }

    @GetMapping("/{nombreUsuario}")
    public UsuarioModel obtenerPorNombreUsuario(@PathVariable @RequestParam String nombreUsuario) {
        return usuarioService.obtenerPorNombreUsuario(nombreUsuario);
    }
    
    

}
