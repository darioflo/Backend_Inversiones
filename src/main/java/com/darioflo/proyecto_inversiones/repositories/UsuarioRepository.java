package com.darioflo.proyecto_inversiones.repositories;
import com.darioflo.proyecto_inversiones.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, String>  {

    public UsuarioModel findByNombreUsuario(String nombreUsuario);
    
}
