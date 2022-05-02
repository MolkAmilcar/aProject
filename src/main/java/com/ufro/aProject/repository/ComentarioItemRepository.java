package com.ufro.aProject.repository;

import com.ufro.aProject.model.ComentarioItem;
import com.ufro.aProject.model.ComentarioPersonaje;
import org.springframework.data.repository.CrudRepository;

public interface ComentarioItemRepository extends CrudRepository<ComentarioItem, Long> {
    Iterable<ComentarioItem> findAllByItemIdOrderByFechaDesc(Long ItemId);
}
