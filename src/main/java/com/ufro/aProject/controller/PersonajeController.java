package com.ufro.aProject.controller;

import com.ufro.aProject.model.Personaje;
import com.ufro.aProject.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PersonajeController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @RequestMapping("/personajes")
    public String index(Model model){
        model.addAttribute("personajes", personajeRepository.findAll());
        return "personajes";
    }

    @GetMapping("/personaje")
    public String fichaPersonaje(@RequestParam(value="id") Long id, Model model){
        Optional<Personaje> personaje=personajeRepository.findById(id);
        model.addAttribute("personaje",personaje.orElseThrow());
        return "ficha-personaje";
    }

}
