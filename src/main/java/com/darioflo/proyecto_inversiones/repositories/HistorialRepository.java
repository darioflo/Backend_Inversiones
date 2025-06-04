package com.darioflo.proyecto_inversiones.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.darioflo.proyecto_inversiones.models.HistorialModel;

@Repository
public interface HistorialRepository extends CrudRepository<HistorialModel,String> {

    
}
