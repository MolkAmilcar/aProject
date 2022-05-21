package com.ufro.aProject.repository;

import com.ufro.aProject.model.Item;
import com.ufro.aProject.model.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ItemRepository extends CrudRepository<Item, Long> {
    /**
     * En este repositorio se define el script SQL de busqueda de Items en base al nombre correspondiente.
     * @param nombre El nombre del Item a ser buscado
     */
    @Query("SELECT m FROM Item m WHERE m.nombre LIKE %:nombre%")
    List<Item> searchByNombreLike(@Param("nombre") String nombre);
}