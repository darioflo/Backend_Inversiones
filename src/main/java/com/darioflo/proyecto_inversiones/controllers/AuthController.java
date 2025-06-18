package com.darioflo.proyecto_inversiones.controllers;

import com.darioflo.proyecto_inversiones.models.UsuarioModel;
import com.darioflo.proyecto_inversiones.repositories.UsuarioRepository;
import com.darioflo.proyecto_inversiones.utils.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String nombreUsuario = body.get("nombreUsuario");
        String clave = body.get("clave");

        logger.info(nombreUsuario);
        UsuarioModel usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        if (usuario == null || !usuario.getClave().equals(clave)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Usuario o clave incorrectos"));
        }

        String token = jwtUtil.generarToken(nombreUsuario);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("jwt", token);
        respuesta.put("usuario", usuario);

        return ResponseEntity.ok(respuesta);
    }
}
