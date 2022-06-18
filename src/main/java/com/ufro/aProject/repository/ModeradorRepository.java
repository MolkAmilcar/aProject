package com.ufro.aProject.repository;

import com.ufro.aProject.model.Moderador;
import org.springframework.data.repository.CrudRepository;

public interface ModeradorRepository extends CrudRepository<Moderador, Long> {
     Moderador findByNombre(String nombre);

}