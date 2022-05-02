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

@Controller
public class PersonajeController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private ComentarioPersonajeRepository comentarioPersonajeRepository;

    @Autowired
    private NombreRepository nombreRepository;

    @RequestMapping("/personajes")
    public String index(Model model){
        model.addAttribute("personajes", personajeRepository.findAll());
        return "personajes";
    }

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

    @PostMapping("/personaje/nuevo-comentario")
    public String nuevoComentarioPersonaje(@ModelAttribute ComentarioPersonaje comentarioPersonaje){
        Date date = new Date();
        Timestamp sqlTimestamp = new Timestamp(date.getTime());
        comentarioPersonaje.setFecha(sqlTimestamp);
        comentarioPersonaje.setNombre(generarNombreComentario());
        comentarioPersonajeRepository.save(comentarioPersonaje);
        return "redirect:/personaje?id="+comentarioPersonaje.getPersonaje().getId();
    }

    public String generarNombreComentario(){
        String nombreUsuario;
        ArrayList<Nombre> nombres = (ArrayList<Nombre>) nombreRepository.findAll();
        nombreUsuario= nombres.get((int) (Math.random() * ((nombres.size()-1) - 0) + 0)).getPrimerNombre();
        nombreUsuario= nombreUsuario + " "+nombres.get((int) (Math.random() * ((nombres.size()-1) - 0) + 0)).getSegundoNombre();

        return nombreUsuario;
    }

}
