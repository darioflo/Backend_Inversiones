package com.darioflo.proyecto_inversiones.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.darioflo.proyecto_inversiones.models.InversionesModel;


@Repository
public interface InversionesRepository extends CrudRepository<InversionesModel, String>{

    public InversionesModel findByIdInversion(String idInversion);

    public InversionesModel findByNombre(String nombre);
    

    
}
