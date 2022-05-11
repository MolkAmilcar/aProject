package com.ufro.aProject.repository;

import com.ufro.aProject.model.Habilidad;
import org.springframework.data.repository.CrudRepository;

/**
 * Este repositorio se encarga de vincular las habilidades de un personaje a los almacenados en la base de datos.
 *
 * @author Isidora Albayay
 */
public interface HabilidadRepository extends CrudRepository<Habilidad, Long> {}