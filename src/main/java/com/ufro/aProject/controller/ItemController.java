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

/**
 * Esta controlador está encargado de controlar y mostrar los detalles de item.
 *
 * @author Isidora Albayay
 */
@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ComentarioItemRepository comentarioItemRepository;

    @Autowired
    private NombreRepository nombreRepository;

    /**
     * Este metodo muestra una vista con el listado del total de items registrados.
     * @return Devuelve el archivo con la vista del listado total de items.
     * */
    @RequestMapping("/items")
    public String index(Model model){
        model.addAttribute("items", itemRepository.findAll());
        return "items";
    }

    /**
     * Este metodo muestra la vista detallada del Item correspondiente al seleccionar un Item del listado de items.
     * @param id EL número identificador del Item.
     * @return Devuelve el archivo con la vista del detalle del Item específico.
     * */
    @GetMapping("/item")
    public String fichaItem(@RequestParam(value="id") Long id, Model model){
        Optional<Item> item =itemRepository.findById(id);
        model.addAttribute("item",item.orElseThrow());
        model.addAttribute("comentarios",comentarioItemRepository.findAllByItemIdOrderByFechaDesc(id));
        return "ficha-item";
    }

    /**
     * Este metodo genera e incorpora un nuevo comentario a la vista de detalle del Item.
     * @param comentarioItem EL Comentario correspondiente al item.
     * @return Devuelve un redireccionamiento al Item correspondiente con su nuevo de Comentario.
     * */
    @PostMapping("/item/nuevo-comentario")
    public String nuevoComentarioItem(@ModelAttribute ComentarioItem comentarioItem){
        Date date = new Date();
        Timestamp sqlTimestamp = new Timestamp(date.getTime());
        comentarioItem.setFecha(sqlTimestamp);
        comentarioItem.setNombre(generarNombreComentario());
        comentarioItemRepository.save(comentarioItem);
        return "redirect:/item?id="+comentarioItem.getItem().getId();
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
