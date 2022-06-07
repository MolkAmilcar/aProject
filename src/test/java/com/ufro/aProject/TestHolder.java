package com.ufro.aProject;

import com.ufro.aProject.model.*;
import com.ufro.aProject.repository.ModeradorRepository;
import com.ufro.aProject.repository.PersonajeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestHolder {

    @Autowired
    PersonajeRepository personajeRepository;

    @Autowired
    ModeradorRepository moderadorRepository;

    @Test
    @DisplayName("Encontrar Moderador por nombre equals")
    void findModeradorByNombreTest1() {
        String expected = "Molk";
        Moderador moderador = moderadorRepository.findByNombre(expected);
        assertEquals(expected, moderador.getNombre());
    }

    @Test
    @DisplayName("Encontrar Moderador por nombre true")
    void findModeradorByNombreTest2() {
        String expected = "Molk";
        Moderador moderador = moderadorRepository.findByNombre(expected);
        assertTrue(moderador.getNombre().equals(expected));
    }

    @Test
    @DisplayName("Encontrar Moderador por nombre not null")
    void findModeradorByNombreTest3() {
        String expected = "Molk";
        Moderador moderador = moderadorRepository.findByNombre(expected);
        assertNotNull(moderador.getNombre());
    }

    @Test
    @DisplayName("Encontrar Moderador por nombre not equals")
    void findModeradorByNombreTest4() {
        Moderador moderador = moderadorRepository.findByNombre("Molk");
        assertNotEquals("Pedro", moderador.getNombre());
    }

    @ParameterizedTest
    @DisplayName("Buscar Personaje por nombre")
    @ValueSource(strings = {"Pyke", "Acrid", "Inozuke", "Grimm", "Munchies", "Shovel Knight"})
    void searchPersonajeByNombreLikeTest1(String nombres) {
        List<Personaje> resultado = personajeRepository.searchByNombreLike(nombres);
        assertEquals(nombres, resultado.get(0).getNombre());
    }

    @ParameterizedTest
    @DisplayName("Buscar Personaje por nombre")
    @ValueSource(strings = {"Pyke", "Acrid", "Inozuke", "Grimm", "Munchies", "Shovel Knight"})
    void searchPersonajeByNombreLikeTest2(String nombres) {
        List<Personaje> resultado = personajeRepository.searchByNombreLike(nombres);
        assertNotEquals("not", resultado.get(0).getNombre());
    }

    @ParameterizedTest
    @DisplayName("Buscar Personaje por nombre")
    @ValueSource(strings = {"Pyke", "Acrid", "Inozuke", "Grimm", "Munchies", "Shovel Knight"})
    void searchPersonajeByNombreLikeTest3(String nombres) {
        List<Personaje> resultado = personajeRepository.searchByNombreLike(nombres);
        assertNotNull(resultado.get(0).getNombre());
    }

    @ParameterizedTest
    @DisplayName("Buscar Personaje por nombre")
    @ValueSource(strings = {"Pyke", "Acrid", "Inozuke", "Grimm", "Munchies", "Shovel Knight"})
    void searchPersonajeByNombreLikeTest4(String nombres) {
        List<Personaje> resultado = personajeRepository.searchByNombreLike(nombres);
        assertTrue(resultado.get(0).getNombre().equals(nombres));
    }
}
