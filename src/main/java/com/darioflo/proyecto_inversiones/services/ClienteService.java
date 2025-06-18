package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.darioflo.proyecto_inversiones.models.ClienteModel;
import com.darioflo.proyecto_inversiones.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente (ClienteModel clienteNuevo){
        return clienteRepository.save(clienteNuevo);
    }

    public ClienteModel obtenerClientePorID(String id){
        return clienteRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado"));
    }

    public ArrayList<ClienteModel> obtenerClientesPorNombre(String nombre){
        ArrayList<ClienteModel> clientes = (ArrayList<ClienteModel>) clienteRepository.findByNombre(nombre);
        if (clientes.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existen usuarios con ese nombre");
    }
    return clientes;
}

    public boolean eliminarCliente(String id){
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
