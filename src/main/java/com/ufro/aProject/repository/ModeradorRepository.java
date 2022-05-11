package com.ufro.aProject.repository;

import com.ufro.aProject.model.Moderador;
import org.springframework.data.repository.CrudRepository;

/**
 * Este repositorio se encarga de vincular cada Moderador al registrado en la base de datos.
 *
 * @author Isidora Albayay
 */
public interface ModeradorRepository extends CrudRepository<Moderador, Long> {}