package com.ufro.aProject.services;

import com.ufro.aProject.repository.ModeradorRepository;
import org.springframework.data.repository.CrudRepository;
/**
 * Esta gestor de servicios se emplea para dar funcionamiento básico a un servicio requerido por SecurityConfig.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
public class GenericServices<T,ID>{

    protected CrudRepository<T, ID> repository;

    public GenericServices(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

}
