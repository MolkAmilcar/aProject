package com.ufro.aProject.services;

import com.ufro.aProject.repository.ModeradorRepository;
import org.springframework.data.repository.CrudRepository;

public class GenericServices<T,ID>{

    protected CrudRepository<T, ID> repository;

    public GenericServices(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

}
