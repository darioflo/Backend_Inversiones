package com.darioflo.proyecto_inversiones.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<ClienteModel> obtenerClientePorID(String id){
        return clienteRepository.findById(id);
    }

    public ArrayList<ClienteModel> obtenerClientesPorNombre(String nombre){
        return (ArrayList<ClienteModel>) clienteRepository.findByNombre(nombre);
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
