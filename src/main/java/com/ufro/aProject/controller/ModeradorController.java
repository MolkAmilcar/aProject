package com.ufro.aProject.controller;

import com.ufro.aProject.model.ComentarioItem;
import com.ufro.aProject.model.ComentarioPersonaje;
import com.ufro.aProject.model.Item;
import com.ufro.aProject.model.Personaje;
import com.ufro.aProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/moderador")
public class ModeradorController {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private ComentarioPersonajeRepository comentarioPersonajeRepository;

    @Autowired
    private NombreRepository nombreRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ComentarioItemRepository comentarioItemRepository;


    @GetMapping
    public String indexModerador(){
        return "vistasModerador/index-moderador";
    }

    @RequestMapping("/sobre-nosotros")
    public String sobreNosotros(){
        return "vistasModerador/sobre-nosotros";
    }

    @RequestMapping("/faq")
    public String faq(){
        return "vistasModerador/faq";
    }

    //Personajes
    @RequestMapping("/personajes")
    public String index(Model model){
        model.addAttribute("personajes", personajeRepository.findAll());
        return "vistasModerador/personajes";
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
        return "vistasModerador/ficha-personaje";

    }

    @GetMapping("/items")
    public String items(Model model){
        model.addAttribute("items", itemRepository.findAll());
        return "vistasModerador/items-moderador";
    }

    @GetMapping("/item")
    public String fichaItem(@RequestParam(value="id") Long id, Model model){
        Optional<Item> item =itemRepository.findById(id);
        model.addAttribute("item",item.orElseThrow());
        model.addAttribute("comentarios",comentarioItemRepository.findAllByItemIdOrderByFechaDesc(id));
        return "vistasModerador/ficha-item";
    }

    @PostMapping("/item/eliminar-comentario")
    public String eliminarComentarioItem(@RequestParam(value="id") Long id){
        Long idItem= comentarioItemRepository.findById(id).get().getItem().getId();
        comentarioItemRepository.deleteById(id);
        return "redirect:/moderador/item?id="+idItem;
    }

    @PostMapping("/personaje/eliminar-comentario")
    public String eliminarComentarioPersonaje(@RequestParam(value="id") Long id){
        Long idItem= comentarioPersonajeRepository.findById(id).get().getPersonaje().getId();
        comentarioPersonajeRepository.deleteById(id);
        return "redirect:/moderador/personaje?id="+idItem;
    }

}
