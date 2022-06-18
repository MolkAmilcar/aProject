package com.ufro.aProject;

import com.ufro.aProject.model.ComentarioItem;
import com.ufro.aProject.model.ComentarioPersonaje;
import com.ufro.aProject.repository.ComentarioItemRepository;
import com.ufro.aProject.repository.ComentarioPersonajeRepository;
import com.ufro.aProject.repository.ItemRepository;
import com.ufro.aProject.repository.PersonajeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ComentarioPersonajeRepositoryTest {

    @Autowired
    private ComentarioPersonajeRepository comentarioPersonajeRepository;

    @Autowired
    private PersonajeRepository personajeRepository;

    @DisplayName("Buscar comentarios de una ficha de personaje")
    @ParameterizedTest
    @CsvSource({"2022-05-21 10:52:49.533000,Que buen personaje,Hada", "2022-06-21 10:52:49.533000,Hola amigos,Duende"})
    public void testFindAllByPersonajeIdOrderByFechaDesc( String fecha, String mensaje, String nombre) {
        List<ComentarioPersonaje> comentariosIniciales = new ArrayList<>();
        comentarioPersonajeRepository.findAllByPersonajeIdOrderByFechaDesc(personajeRepository.findById(1L).get().getId()).forEach(e -> comentariosIniciales.add(e));
        int cantidadEsperada= comentariosIniciales.size()+1;
        java.sql.Timestamp ts = java.sql.Timestamp.valueOf( fecha ) ;
        ComentarioPersonaje comentario = new ComentarioPersonaje(ts,mensaje,nombre);
        comentario.setPersonaje(personajeRepository.findById(1L).get());
        comentarioPersonajeRepository.save(comentario);
        List<ComentarioPersonaje> resultado = new ArrayList<>();
        comentarioPersonajeRepository.findAllByPersonajeIdOrderByFechaDesc(personajeRepository.findById(1L).get().getId()).forEach(e -> resultado.add(e));
        Assertions.assertNotNull(comentarioPersonajeRepository.findById(1L));
        Assertions.assertEquals(resultado.size(), cantidadEsperada);
        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertNotNull(resultado);
    }

}
