package com.darioflo.proyecto_inversiones.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.darioflo.proyecto_inversiones.models.ContratoModel;

@Repository
public interface ContratoRepository extends CrudRepository<ContratoModel, String>{
    
    public ContratoModel findByIdContrato(String idContrato);

    public ContratoModel findByIdCuenta(String idCuenta);
}
