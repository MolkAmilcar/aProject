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
 * @author Isidora Albayay
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

        //vidas
        ArrayList<Integer> vidas = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getVida();i++){
            vidas.add(1);
        }
        model.addAttribute("vidas",vidas);
        //daños
        ArrayList<Integer> danos = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getDaño();i++){
            danos.add(1);
        }
        model.addAttribute("danos",danos);
        //velocidades
        ArrayList<Integer> velocidades = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getVelocidad();i++){
            velocidades.add(1);
        }
        model.addAttribute("velocidades",velocidades);
        //sigilos
        ArrayList<Integer> sigilos = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getSigilo();i++){
            sigilos.add(1);
        }
        model.addAttribute("sigilos",sigilos);
        //evasiones
        ArrayList<Integer> evasiones = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getEvasion();i++){
            evasiones.add(1);
        }

        model.addAttribute("evasiones",evasiones);
        //armaduras
        ArrayList<Integer> armaduras = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getArmadura();i++){
            armaduras.add(1);
        }
        model.addAttribute("armaduras",armaduras);
        return "ficha-personaje";
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
