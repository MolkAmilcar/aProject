package com.ufro.aProject.repository;

import com.ufro.aProject.model.ComentarioPersonaje;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioPersonajeRepository extends CrudRepository<ComentarioPersonaje, Long> {

    /**
     * En este repositorio se buscan y ordenan todos los comentarios de un Personaje en base a su fecha de publicación en orden descendente.
     */
    Iterable<ComentarioPersonaje> findAllByPersonajeIdOrderByFechaDesc(Long personajeId);
}
