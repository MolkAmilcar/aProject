package com.ufro.aProject.repository;

import com.ufro.aProject.model.Personaje;
import org.springframework.data.repository.CrudRepository;

/**
 * Este repositorio se encarga de vincular cada Personaje a los almacenados en la base de datos.
 *
 * @author Isidora Albayay
 */
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {}