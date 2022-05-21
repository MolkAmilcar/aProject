package com.ufro.aProject.controller;

import com.ufro.aProject.model.ComentarioPersonaje;
import com.ufro.aProject.repository.ItemRepository;
import com.ufro.aProject.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Esta controlador está encargado de manejar y mostrar la pagina inicial del proyecto.
 *
 * @author Amilcar Celis, Isidora Albayay
 */

@Controller
public class MainController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Este metodo se encarga de mostrar la página de inicio predeterminada.
     * @return Devuelve la vista inicial (index) predeterminado del proyecto.
     * */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * Este metodo se encarga de mostrar la información de el apartado "sobre nosotros" del proyecto.
     * @return Devuelve la vista con la información "sobre nosotros".
     * */
    @RequestMapping("/sobre-nosotros")
    public String sobreNosotros(){
        return "sobre-nosotros";
    }

    /**
     * Este metodo se encarga de mostrar y responder las preguntas frecuentes del proyecto.
     * @return Devuelve la vista con las preguntas frecuentes.
     * */
    @RequestMapping("/faq")
    public String faq(){
        return "faq";
    }

    /**
     * Este metodo se encarga de mostrar la pantalla con el formulario de inicio de sesión del Moderador.
     * @return Devuelve la vista con el inicio de sesión para el Moderador.
     * */
    @RequestMapping("/login")
    public String login(){
        return "vistasModerador/inicio-sesion-moderador";
    }


    //Ojo cambios en vista INDEX y nueva vista resultados-busqueda

    /**
     * Este metodo se encarga de realizar la consulta del elemento que está siendo buscado.
     * @param texto La cadena de texto con el nombre del elemento a ser buscado.
     * @return Devuelve la vista con el resultado de la busqueda.
     * */
    @GetMapping ("/buscar-elemento")
        public String busqueda(@RequestParam(value="texto") String texto, Model model){
        model.addAttribute("personajes", personajeRepository.searchByNombreLike(texto));
        model.addAttribute("items", itemRepository.searchByNombreLike(texto));
        return "resultados-busqueda";
    }
}
