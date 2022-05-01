package com.ufro.aProject.repository;

import com.ufro.aProject.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {}