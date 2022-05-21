package com.ufro.aProject.repository;

import com.ufro.aProject.model.Item;
import com.ufro.aProject.model.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonajeRepository extends CrudRepository<Personaje, Long> {
    /**
     * En este repositorio se define el script SQL de busqueda de Personajes en base al nombre correspondiente.
     * @param nombre El nombre del Personaje a ser buscado
     */
    @Query("SELECT m FROM Personaje m WHERE m.nombre LIKE %:nombre%")
    List<Personaje> searchByNombreLike(@Param("nombre") String nombre);
}