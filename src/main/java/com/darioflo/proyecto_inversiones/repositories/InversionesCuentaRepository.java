package com.darioflo.proyecto_inversiones.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.darioflo.proyecto_inversiones.models.InversionesCuentaModel;

@Repository
public interface InversionesCuentaRepository extends CrudRepository<InversionesCuentaModel, String> {
    
}
