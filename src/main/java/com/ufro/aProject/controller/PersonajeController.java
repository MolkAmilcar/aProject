package com.ufro.aProject.controller;

import com.ufro.aProject.model.ComentarioPersonaje;
import com.ufro.aProject.model.Nombre;
import com.ufro.aProject.model.Personaje;
import com.ufro.aProject.repository.ComentarioPersonajeRepository;
import com.ufro.aProject.repository.NombreRepository;
import com.ufro.aProject.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * Esta controlador está encargado de manejar y mostrar las paginas y redireccionar a las paginas relacionadas a las personajes.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
@Controller
public class PersonajeController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private ComentarioPersonajeRepository comentarioPersonajeRepository;

    @Autowired
    private NombreRepository nombreRepository;

    /**
     * Este metodo muestra una vista con el listado del total de personajes registrados.
     * @return Devuelve el archivo con la vista del listado total de personajes.
     * */
    @RequestMapping("/personajes")
    public String index(Model model){
        model.addAttribute("personajes", personajeRepository.findAll());
        return "personajes";
    }

    /**
     * Este metodo muestra la vista detallada del Personaje correspondiente al seleccionar un Personaje del listado de personajes.
     * @param id EL número identificador del Personaje.
     * @param model
     * @return Devuelve el archivo con la vista del detalle del Personaje específico.
     * */
    @GetMapping("/personaje")
    public String fichaPersonaje(@RequestParam(value="id") Long id, Model model){
        Optional<Personaje> personaje=personajeRepository.findById(id);
        model.addAttribute("personaje",personaje.orElseThrow());
        model.addAttribute("comentarios",comentarioPersonajeRepository.findAllByPersonajeIdOrderByFechaDesc(id));

        model.addAttribute("armaduras",estadisticas(personaje.get().getArmadura()));
        model.addAttribute("evasiones",estadisticas(personaje.get().getEvasion()));
        model.addAttribute("sigilos",estadisticas(personaje.get().getSigilo()));
        model.addAttribute("velocidades",estadisticas(personaje.get().getVelocidad()));
        model.addAttribute("danos",estadisticas(personaje.get().getDaño()));
        model.addAttribute("vidas",estadisticas(personaje.get().getVida()));

        return "ficha-personaje";

    }
    /**
     * Este metodo ayuda a definir la cantidad de puntos de las estadisticas de un personaje
     * @param largo
     * @return Devuelve un ArrayList que representa la cantidad de puntos de estadistica.
     * */
    public ArrayList<Integer> estadisticas( int largo ){
        ArrayList<Integer> estadistica = new ArrayList<Integer>();
        for(int i=0; i<largo;i++){
            estadistica.add(1);
        }
        return estadistica;
    }


    /**
     * Este metodo genera e incorpora un nuevo comentario a la vista de detalle del Personaje.
     * @param comentarioPersonaje EL Comentario correspondiente al Personaje.
     * @return Devuelve un redireccionamiento al Personaje correspondiente con su nuevo de Comentario.
     * */
    @PostMapping("/personaje/nuevo-comentario")
    public String nuevoComentarioPersonaje(@ModelAttribute ComentarioPersonaje comentarioPersonaje){
        Date date = new Date();
        Timestamp sqlTimestamp = new Timestamp(date.getTime());
        comentarioPersonaje.setFecha(sqlTimestamp);
        comentarioPersonaje.setNombre(generarNombreComentario());
        comentarioPersonajeRepository.save(comentarioPersonaje);
        return "redirect:/personaje?id="+comentarioPersonaje.getPersonaje().getId();
    }

    /**
     * Este metodo genera un nombre aleatorio en base a los nombres registrados para el Comentario.
     * @return Devuelve la cadena del nombre aleatorio.
     * */
    public String generarNombreComentario(){
        String nombreUsuario;
        ArrayList<Nombre> nombres = (ArrayList<Nombre>) nombreRepository.findAll();
        nombreUsuario= nombres.get((int) (Math.random() * ((nombres.size()-1) - 0) + 0)).getPrimerNombre();
        nombreUsuario= nombreUsuario + " "+nombres.get((int) (Math.random() * ((nombres.size()-1) - 0) + 0)).getSegundoNombre();

        return nombreUsuario;
    }

}
