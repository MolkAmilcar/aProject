package com.ufro.aProject.repository;

import com.ufro.aProject.model.ComentarioPersonaje;
import org.springframework.data.repository.CrudRepository;

/**
 * Este repositorio se encargade vincular los comentarios de personajes a los almacenados en la base de datos.
 *
 * @author Isidora Albayay
 */
public interface ComentarioPersonajeRepository extends CrudRepository<ComentarioPersonaje, Long> {

    Iterable<ComentarioPersonaje> findAllByPersonajeIdOrderByFechaDesc(Long personajeId);
}
