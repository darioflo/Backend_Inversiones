package com.darioflo.proyecto_inversiones.repositories;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.darioflo.proyecto_inversiones.models.CuentaModel;


@Repository
public interface CuentaRepository extends CrudRepository<CuentaModel,String>{
    
    public abstract ArrayList<CuentaModel> findByIdCliente(String idCliente);
}
