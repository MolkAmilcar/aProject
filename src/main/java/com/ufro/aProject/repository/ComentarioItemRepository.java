package com.ufro.aProject.repository;

import com.ufro.aProject.model.ComentarioItem;
import org.springframework.data.repository.CrudRepository;

interface ComentarioPersonajeItem extends CrudRepository<ComentarioItem, Long> {}
