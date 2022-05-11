package com.ufro.aProject.repository;

import com.ufro.aProject.model.Nombre;
import org.springframework.data.repository.CrudRepository;

/**
 * Este repositorio se encarga de vincular cada Nombre a los almacenados en la base de datos.
 *
 * @author Isidora Albayay
 */
public interface NombreRepository extends CrudRepository<Nombre, Long> {}