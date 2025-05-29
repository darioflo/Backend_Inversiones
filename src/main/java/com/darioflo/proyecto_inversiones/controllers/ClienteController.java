package com.darioflo.proyecto_inversiones.controllers;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darioflo.proyecto_inversiones.models.ClienteModel;
import com.darioflo.proyecto_inversiones.services.ClienteService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel clienteNuevo){
        return clienteService.guardarCliente(clienteNuevo);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorID(@PathVariable("id") String id){
        return this.clienteService.obtenerClientePorID(id);
    }

    @GetMapping(path = "/nombre/{nombre}")
    public ArrayList<ClienteModel> obtenerClientesPorNombre(@PathVariable("nombre")  String nombre){
        return clienteService.obtenerClientesPorNombre(nombre);
    }
    
    @DeleteMapping(path = "/deletebyID/{id}")
    public String borrarClientePorID(@PathVariable("id") String id){
        boolean ok = clienteService.eliminarCliente(id);
        return ok ? "Se eliminó correctamente el usuario con id: "+ id : "No se pudo eliminar el usuario con id: "+id;
    }
}
