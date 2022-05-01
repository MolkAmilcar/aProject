package com.ufro.aProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonajeController {

    @RequestMapping("/personajes")
    public String index(Model model){
        return "personajes";
    }

}
