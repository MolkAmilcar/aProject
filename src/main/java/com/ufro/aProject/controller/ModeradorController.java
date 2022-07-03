package com.ufro.aProject.controller;

import com.ufro.aProject.model.Item;
import com.ufro.aProject.model.Personaje;
import com.ufro.aProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Esta controlador está encargado de manejar y mostrar todos de elementos de la página a disposición de los moderadores e incluir sus características de moderación correspondientes.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
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

    /**
     * Este metodo se encarga de mostrar la página de inicio correspondiente al moderador.
     * @return Devuelve la vista inicial (index) correspondiente al moderador.
     * */
    @GetMapping
    public String indexModerador(){
        return "vistasModerador/index-moderador";
    }

    /**
     * Este metodo se encarga de mostrar la información de el apartado "sobre nosotros" del proyecto.
     * @return Devuelve la vista con la información "sobre nosotros" correspondiente al moderador.
     * */
    @RequestMapping("/sobre-nosotros")
    public String sobreNosotros(){
        return "vistasModerador/sobre-nosotros";
    }

    /**
     * Este metodo se encarga de mostrar y responder las preguntas frecuentes del proyecto.
     * @return Devuelve la vista con las preguntas frecuentes correspondientes al moderador.
     * */
    @RequestMapping("/faq")
    public String faq(){
        return "vistasModerador/faq";
    }

    /**
     * Este metodo muestra una vista con el listado del total de personajes registrados a los que puede accededer un Moderador.
     * @return Devuelve el archivo con la vista del listado total de personajes tiene acceso un Moderador.
     * */
    @RequestMapping("/personajes")
    public String index(Model model){
        model.addAttribute("personajes", personajeRepository.findAll());
        return "vistasModerador/personajes";
    }

    /**
     * Este metodo muestra la vista detallada del Personaje correspondiente al seleccionar un Personaje del listado de personajes, junto a sus correspondientes herramientas de moderación.
     * @param id EL número identificador del Personaje.
     * @param model
     * @return Devuelve el archivo con la vista del detalle del Personaje específico y las herramientas de moderación.
     * */
    @GetMapping("/personaje")
    public String fichaPersonaje(@RequestParam(value="id") Long id, Model model){
        Optional<Personaje> personaje=personajeRepository.findById(id);
        model.addAttribute("personaje",personaje.orElseThrow());
        model.addAttribute("comentarios",comentarioPersonajeRepository.findAllByPersonajeIdOrderByFechaDesc(id));

        ArrayList<Integer> vidas = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getVida();i++){
            vidas.add(1);
        }
        model.addAttribute("vidas",vidas);

        ArrayList<Integer> danos = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getDaño();i++){
            danos.add(1);
        }
        model.addAttribute("danos",danos);

        ArrayList<Integer> velocidades = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getVelocidad();i++){
            velocidades.add(1);
        }
        model.addAttribute("velocidades",velocidades);

        ArrayList<Integer> sigilos = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getSigilo();i++){
            sigilos.add(1);
        }
        model.addAttribute("sigilos",sigilos);

        ArrayList<Integer> evasiones = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getEvasion();i++){
            evasiones.add(1);
        }

        model.addAttribute("evasiones",evasiones);

        ArrayList<Integer> armaduras = new ArrayList<Integer>();
        for(int i=0; i<personaje.get().getArmadura();i++){
            armaduras.add(1);
        }
        model.addAttribute("armaduras",armaduras);
        return "vistasModerador/ficha-personaje";

    }

    /**
     * Este metodo muestra una vista con el listado del total de items registrados a los que puede accededer un Moderador.
     * @return Devuelve el archivo con la vista del listado total de items a los que tiene acceso un Moderador.
     * */
    @GetMapping("/items")
    public String items(Model model){
        model.addAttribute("items", itemRepository.findAll());
        return "vistasModerador/items-moderador";
    }

    /**
     * Este metodo muestra la vista detallada del Item correspondiente al seleccionar un Item del listado de items correspondiente a un Moderador, junto a sus respectivas herramientas de moderación.
     * @param id EL número identificador del Item.
     * @return Devuelve el archivo con la vista del detalle del Item específico y las herramientas de moderación.
     * */
    @GetMapping("/item")
    public String fichaItem(@RequestParam(value="id") Long id, Model model){
        Optional<Item> item =itemRepository.findById(id);
        model.addAttribute("item",item.orElseThrow());
        model.addAttribute("comentarios",comentarioItemRepository.findAllByItemIdOrderByFechaDesc(id));
        return "vistasModerador/ficha-item";
    }

    /**
     * Este metodo elimina un comentario correspondiente a un Item específico.
     * @param id EL id del comentario que quiere ser eliminado.
     * @return Devuelve un redireccionamiento al Item correspondiente, con la eliminación del comentario aplicada.
     * */
    @PostMapping("/item/eliminar-comentario")
    public String eliminarComentarioItem(@RequestParam(value="id") Long id){
        Long idItem= comentarioItemRepository.findById(id).get().getItem().getId();
        comentarioItemRepository.deleteById(id);
        return "redirect:/moderador/item?id="+idItem;
    }

    /**
     * Este metodo elimina un comentario correspondiente a un Personaje específico.
     * @param id EL id del comentario que quiere ser eliminado.
     * @return Devuelve un redireccionamiento al Personaje correspondiente, con la eliminación del comentario aplicada.
     * */
    @PostMapping("/personaje/eliminar-comentario")
    public String eliminarComentarioPersonaje(@RequestParam(value="id") Long id){
        Long idItem= comentarioPersonajeRepository.findById(id).get().getPersonaje().getId();
        comentarioPersonajeRepository.deleteById(id);
        return "redirect:/moderador/personaje?id="+idItem;
    }

    /**
     * Este metodo se encarga de realizar la consulta del elemento que está siendo buscado por un Moderador.
     * @param texto La cadena de texto con el nombre del elemento a ser buscado.
     * @return Devuelve la vista con el resultado de la busqueda y las herramientas de moderación.
     * */
    @GetMapping ("/buscar-elemento")
    public String busqueda(@RequestParam(value="texto") String texto, Model model){
        model.addAttribute("personajes", personajeRepository.searchByNombreLike(texto));
        model.addAttribute("items", itemRepository.searchByNombreLike(texto));
        return "vistasModerador/resultados-busqueda-moderador";
    }

    /**
     * Este metodo direcciona a la vista del formulario de registro de item
     * @return Devuelve el archivo con la vista del formulario
     * */
    @RequestMapping("/registrar-item")
    public String registrarItem(){
        return "vistasModerador/registrarItem";
    }

    /**
     * Este metodo guarda los datos ingresados en la base de datos en la tabla de item de nuestra base de datos
     * @param item item que será guardado en la base de datos
     * @return redirecciona a la pagina del listado de items
     * */
    @PostMapping("/registrar-item/nuevo-item")
    public String nuevoItem(@ModelAttribute Item item){
        itemRepository.save(item);
        return "redirect:/moderador/items";
    }

    /**
     * Este metodo direcciona a la vista del formulario de registro de personaje
     * @return Devuelve el archivo con la vista del formulario
     * */
    @RequestMapping("/registrar-personaje")
    public String registrarPersonaje(){
        return "vistasModerador/registrarPersonaje";
    }

    /**
     * Este metodo guarda los datos ingresados en la base de datos en la tabla de personaje de nuestra base de datos
     * @param personaje personaje que será guardado en la base de datos
     * @return redirecciona a la pagina del listado de personajes
     * */
    @PostMapping("/registrar-personaje/nuevo-personaje")
    public String nuevoPersonaje(@ModelAttribute Personaje personaje){
        personajeRepository.save(personaje);
        return "redirect:/moderador/personajes";
    }




}
