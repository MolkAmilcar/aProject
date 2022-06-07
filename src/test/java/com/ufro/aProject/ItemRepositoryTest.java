package com.ufro.aProject;

import com.ufro.aProject.model.Item;
import com.ufro.aProject.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @DisplayName("Busqueda de texto")
    @ParameterizedTest
    @CsvSource({"a", "ojo", "p"})
    public void testSearchByNombreLike(String texto){
        List<Item> resultadosBusqueda = itemRepository.searchByNombreLike(texto);
        //variabilidad de pruebas
        Assertions.assertTrue(resultadosBusqueda.size()>0);
        Assertions.assertNotNull(resultadosBusqueda);
    }
}
