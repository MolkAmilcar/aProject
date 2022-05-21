package com.ufro.aProject.repository;

import com.ufro.aProject.model.ComentarioItem;
import com.ufro.aProject.model.ComentarioPersonaje;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioItemRepository extends CrudRepository<ComentarioItem, Long> {
    /**
     * En este repositorio se buscan y ordenan todos los comentarios de un Item en base a su fecha de publicación en orden descendente.
     */
    Iterable<ComentarioItem> findAllByItemIdOrderByFechaDesc(Long ItemId);
}
