package com.ufro.aProject.controller;

import com.ufro.aProject.model.ComentarioPersonaje;
import com.ufro.aProject.repository.ItemRepository;
import com.ufro.aProject.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/sobre-nosotros")
    public String sobreNosotros(){
        return "sobre-nosotros";
    }

    @RequestMapping("/faq")
    public String faq(){
        return "faq";
    }

    @RequestMapping("/login")
    public String login(){
        return "vistasModerador/inicio-sesion-moderador";
    }


    //Ojo cambios en vista INDEX y nueva vista resultados-busqueda

    @GetMapping ("/buscar-elemento")
        public String busqueda(@RequestParam(value="texto") String texto, Model model){
        model.addAttribute("personajes", personajeRepository.searchByNombreLike(texto));
        model.addAttribute("items", itemRepository.searchByNombreLike(texto));
        return "resultados-busqueda";
    }
}
