package com.ufro.aProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Esta controlador está encargado de controlar y mostrar la pagina inicial del proyecto.
 *
 * @author Isidora Albayay
 */
@Controller
public class MainController {

    /**
     * Este metodo se encarga de mostrar la página de inicio predeterminada.
     * @return Devuelve el archivo inicial (index) predeterminado del proyecto.
     * */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * Este metodo se encarga de mostrar la información de el apartado "sobre nosotros" del proyecto.
     * @return Devuelve el archivo con la información "sobre nosotros".
     * */
    @RequestMapping("/sobre-nosotros")
    public String sobreNosotros(){
        return "sobre-nosotros";
    }

    /**
     * Este metodo se encarga de mostrar y responder las preguntas frecuentes del proyecto.
     * @return Devuelve el archivo con las preguntas frecuentes.
     * */
    @RequestMapping("/faq")
    public String faq(){
        return "faq";
    }

}
