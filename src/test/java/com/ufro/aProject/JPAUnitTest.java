package com.ufro.aProject;

import com.ufro.aProject.model.*;
import com.ufro.aProject.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class JPAUnitTest {
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
    public void comentariosItemIsNotEmpty(){
        Iterable comentarios = comentarioItemRepository.findAll();
        assertThat(comentarios).isNotEmpty();
    }

    @Test
    public void comentariosPersonajeIsNotEmpty(){
        Iterable comentarios = comentarioPersonajeRepository.findAll();
        assertThat(comentarios).isNotEmpty();
    }

    @Test
    public void habilidadsIsNotEmpty(){
        Iterable habilidades = habilidadRepository.findAll();
        assertThat(habilidades).isNotEmpty();
    }

    @Test
    public void itemsIsNotEmpty(){
        Iterable items = itemRepository.findAll();
        assertThat(items).isNotEmpty();
    }

    @Test
    public void moderadoresIsNotEmpty(){
        Iterable moderadores = moderadorRepository.findAll();
        assertThat(moderadores).isNotEmpty();
    }

    @Test
    public void nombresIsNotEmpty(){
        Iterable nombres = nombreRepository.findAll();
        assertThat(nombres).isNotEmpty();
    }

    @Test
    public void personajesIsNotEmpty(){
        Iterable personajes = personajeRepository.findAll();
        assertThat(personajes).isNotEmpty();
    }

    @Test
    public void ingresoModerador(){
        Moderador moderador = moderadorRepository.save(new Moderador(null, "Test", "$2a$12$baupqNti3Y2bOjn7igiOpeS0cE/wXuciqN7P0ZvSp6Y/f051JL.dW"));
        assertThat(moderador).hasFieldOrPropertyWithValue("nombre", "Test");
        assertThat(moderador).hasFieldOrPropertyWithValue("constrasena", "$2a$12$baupqNti3Y2bOjn7igiOpeS0cE/wXuciqN7P0ZvSp6Y/f051JL.dW");
    }

    @Test
    public void ingresoHabilidad(){
        Habilidad habilidad = habilidadRepository.save(new Habilidad(null, "Habilidad", "Esta habilidad es un test", 10L));
        assertThat(habilidad).hasFieldOrPropertyWithValue("nombre", "Habilidad");
        assertThat(habilidad).hasFieldOrPropertyWithValue("descripcion", "Esta habilidad es un test");
        assertThat(habilidad).hasFieldOrPropertyWithValue("enfriamiento", 10L);
    }

    @Test
    public void ingresoComentarioItem(){
        java.sql.Timestamp ts = java.sql.Timestamp.valueOf( "2022-05-21 10:52:49.533000") ;
        ComentarioItem comentarioItem= comentarioItemRepository.save(new ComentarioItem(ts,"comentario de prueba", "usuario de prueba",null));
        comentarioItem.setItem(itemRepository.findById(1L).get());
        assertThat(comentarioItem).hasFieldOrPropertyWithValue("nombre", "usuario de prueba");
        assertThat(comentarioItem).hasFieldOrPropertyWithValue("mensaje", "comentario de prueba");
    }

    @Test
    public void ingresoComentarioPersonaje(){
        java.sql.Timestamp ts = java.sql.Timestamp.valueOf( "2022-05-21 10:52:49.533000") ;
        ComentarioPersonaje comentarioPersonaje= comentarioPersonajeRepository.save(new ComentarioPersonaje(ts,"comentario de prueba", "usuario de prueba"));
        comentarioPersonaje.setPersonaje(personajeRepository.findById(1L).get());
        assertThat(comentarioPersonaje).hasFieldOrPropertyWithValue("nombre", "usuario de prueba");
        assertThat(comentarioPersonaje).hasFieldOrPropertyWithValue("mensaje", "comentario de prueba");
    }
}
