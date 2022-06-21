package com.ufro.aProject.repository;

import com.ufro.aProject.model.Habilidad;
import org.springframework.data.repository.CrudRepository;

public interface HabilidadRepository extends CrudRepository<Habilidad, Long> {
    Habilidad findByNombre(String nombre);
}