package com.YobossApp_11.Yobossapp.repositories;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
/*import org.springframework.stereotype.Repository;*/

import com.YobossApp_11.Yobossapp.models.UsuarioModel;
import com.zaxxer.hikari.util.FastList;

/*@Repository*/
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    FastList<UsuarioModel> findByNombre(String nombre);


    Optional<UsuarioModel> findOneByEmail(String email);

}
