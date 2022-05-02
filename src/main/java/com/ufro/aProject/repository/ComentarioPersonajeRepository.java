package com.ufro.aProject.repository;

import com.ufro.aProject.model.ComentarioPersonaje;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioPersonajeRepository extends CrudRepository<ComentarioPersonaje, Long> {

    Iterable<ComentarioPersonaje> findAllByPersonajeIdOrderByFechaDesc(Long personajeId);
}
