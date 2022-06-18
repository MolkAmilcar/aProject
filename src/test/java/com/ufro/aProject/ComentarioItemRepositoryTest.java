package com.ufro.aProject;

import com.ufro.aProject.model.ComentarioItem;
import com.ufro.aProject.repository.ComentarioItemRepository;
import com.ufro.aProject.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
public class ComentarioItemRepositoryTest {

    @Autowired
    private ComentarioItemRepository comentarioItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @DisplayName("Buscar comentarios de una ficha de item")
    @ParameterizedTest
    @CsvSource({"300,2022-05-21 10:52:49.533000,Hola comunidad,Brujo", "300,2022-05-21 10:52:49.533000,Hola amigos,Flor"})
    public void testFindAllByItemIdOrderByFechaDesc(Long id, String fecha, String mensaje, String nombre) {
        List<ComentarioItem> comentariosIniciales = new ArrayList<>();
        comentarioItemRepository.findAllByItemIdOrderByFechaDesc(itemRepository.findById(1L).get().getId()).forEach(e -> comentariosIniciales.add(e));
        int cantidadEsperada= comentariosIniciales.size()+1;
        java.sql.Timestamp ts = java.sql.Timestamp.valueOf( fecha ) ;
        ComentarioItem comentario = new ComentarioItem(ts,mensaje,nombre,id);
        comentario.setItem(itemRepository.findById(1L).get());
        comentarioItemRepository.save(comentario);
        List<ComentarioItem> resultado = new ArrayList<>();
        comentarioItemRepository.findAllByItemIdOrderByFechaDesc(itemRepository.findById(1L).get().getId()).forEach(e -> resultado.add(e));
        Assertions.assertNotNull(comentarioItemRepository.findById(1L));
        Assertions.assertEquals(resultado.size(), cantidadEsperada);
        Assertions.assertFalse(resultado.isEmpty());
        Assertions.assertNotNull(resultado);

    }

}
