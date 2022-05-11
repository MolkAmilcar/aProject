package com.ufro.aProject.repository;

import com.ufro.aProject.model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Este repositorio se encarga de vincular cada Item a los almacenados en la base de datos.
 *
 * @author Isidora Albayay
 */
public interface ItemRepository extends CrudRepository<Item, Long> {}