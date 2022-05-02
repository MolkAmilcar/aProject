package com.ufro.aProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

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

}
