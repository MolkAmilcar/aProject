package com.ufro.aProject.repository;

import com.ufro.aProject.model.ComentarioItem;
import com.ufro.aProject.model.ComentarioPersonaje;
import org.springframework.data.repository.CrudRepository;

/**
 * Este repositorio se encarga de vincular los comentarios de item a los almacenados en la base de datos.
 *
 * @author Isidora Albayay
 */
public interface ComentarioItemRepository extends CrudRepository<ComentarioItem, Long> {
    Iterable<ComentarioItem> findAllByItemIdOrderByFechaDesc(Long ItemId);
}
