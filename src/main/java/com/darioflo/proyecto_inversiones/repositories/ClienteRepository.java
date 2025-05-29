package com.darioflo.proyecto_inversiones.repositories;
import com.darioflo.proyecto_inversiones.models.ClienteModel;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel,String>{

    public abstract ClienteModel findByIdCliente(String idCliente);
    public abstract ArrayList<ClienteModel> findByNombre(String nombre);
}
