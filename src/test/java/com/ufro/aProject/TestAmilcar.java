package com.ufro.aProject;

import com.ufro.aProject.model.Habilidad;
import com.ufro.aProject.model.Moderador;
import com.ufro.aProject.model.Nombre;
import com.ufro.aProject.model.Personaje;
import com.ufro.aProject.repository.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestAmilcar {
    @Autowired
    ModeradorRepository moderadorRepository;

    @Autowired
    PersonajeRepository personajeRepository;

    @Autowired
    HabilidadRepository habilidadRepository;

    @Autowired
    ComentarioItemRepository comentarioItemRepository;

    @Autowired
    ComentarioPersonajeRepository comentarioPersonajeRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    NombreRepository nombreRepository;

    @Test
    public void ingresoNombre(){
        String primerNombre = "Chaman";
        String segundoNombre = "poderoso";
        Nombre nombre = nombreRepository.save(new Nombre(primerNombre, segundoNombre));
        assertThat(nombre).hasFieldOrPropertyWithValue("primerNombre", primerNombre);
        assertThat(nombre).hasFieldOrPropertyWithValue("segundoNombre", segundoNombre);
    }

    @Test
    @Order(1)
    public void ingresoHabilidad(){
        String nombre = "Test";
        String descripcion = "Habilidad test";
        Long enfriamiento = 10L;
        Habilidad habilidad = habilidadRepository.save(new Habilidad(null, nombre, descripcion, enfriamiento));
        assertThat(habilidad).hasFieldOrPropertyWithValue("nombre", nombre);
        assertThat(habilidad).hasFieldOrPropertyWithValue("descripcion", descripcion);
        assertThat(habilidad).hasFieldOrPropertyWithValue("enfriamiento", enfriamiento);
    }

    @Test
    @Order(2)
    public void ingresoPersonaje(){
        List<Habilidad> habilidades = new ArrayList<Habilidad>();
        String nombre = "Test";
        String descripcion = "Test";
        String imagen = "http://cdn.onlinewebfonts.com/svg/img_89726.png";

        habilidades.add(habilidadRepository.findByNombre("Test"));
        habilidades.add(habilidadRepository.findByNombre("Test"));


        Personaje personaje = personajeRepository.save(new Personaje(nombre, descripcion, imagen,10, 10, 10, 10, 10, 10, habilidades));
        assertThat(personaje).hasFieldOrPropertyWithValue("nombre", nombre);
        assertThat(personaje).hasFieldOrPropertyWithValue("descripcion", descripcion);
        assertThat(personaje).hasFieldOrPropertyWithValue("vida", 10);
    }
}
