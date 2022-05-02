package com.ufro.aProject.controller;

import com.ufro.aProject.model.ComentarioItem;
import com.ufro.aProject.model.Item;
import com.ufro.aProject.model.Nombre;
import com.ufro.aProject.repository.ComentarioItemRepository;
import com.ufro.aProject.repository.ItemRepository;
import com.ufro.aProject.repository.NombreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ComentarioItemRepository comentarioItemRepository;

    @Autowired
    private NombreRepository nombreRepository;

    @RequestMapping("/items")
    public String index(Model model){
        model.addAttribute("items", itemRepository.findAll());
        return "items";
    }

    @GetMapping("/item")
    public String fichaItem(@RequestParam(value="id") Long id, Model model){
        Optional<Item> item =itemRepository.findById(id);
        model.addAttribute("item",item.orElseThrow());
        model.addAttribute("comentarios",comentarioItemRepository.findAllByItemIdOrderByFechaDesc(id));
        return "ficha-item";
    }

    @PostMapping("/item/nuevo-comentario")
    public String nuevoComentarioItem(@ModelAttribute ComentarioItem comentarioItem){
        Date date = new Date();
        Timestamp sqlTimestamp = new Timestamp(date.getTime());
        comentarioItem.setFecha(sqlTimestamp);
        comentarioItem.setNombre(generarNombreComentario());
        comentarioItemRepository.save(comentarioItem);
        return "redirect:/item?id="+comentarioItem.getItem().getId();
    }

    public String generarNombreComentario(){
        String nombreUsuario;
        ArrayList<Nombre> nombres = (ArrayList<Nombre>) nombreRepository.findAll();
        nombreUsuario= nombres.get((int) (Math.random() * ((nombres.size()-1) - 0) + 0)).getPrimerNombre();
        nombreUsuario= nombreUsuario + " "+nombres.get((int) (Math.random() * ((nombres.size()-1) - 0) + 0)).getSegundoNombre();

        return nombreUsuario;
    }

}
