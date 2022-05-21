package com.ufro.aProject.model;

import javax.persistence.*;

/**
 * Esta clase contiene el detalle de los objetos "Items" que serán mostrados por la aplicación.
 *
 * @author Amilcar Celis
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    /**
     * Este constructor está vacío y se usa para instanciar un Item sin valores.
     */
    public Item(){}

    /**
     * Este constructor se emplea para determinar las características y valores de los atributos de un Item.
     *
     * @param id El numero identificador del Item.
     * @param nombre El nombre del Item.
     * @param descripcion La descripción de las características del Item.
     */
    public Item(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void mostrarInformacion() {}

    /**
     * @return Devuelve el id del Item.
     * */
    public Long getId() {
        return id;
    }

    /**
     * @param id Cambia el id del Item.
     * */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Devuelve el nombre del Item.
     * */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Cambia el nombre del Item.
     * */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Devuelve la descripcion del Item.
     * */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Cambia la descripcion del Item.
     * */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Devuelve la ruta de la imagen correspondiente al Item.
     * */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen Cambia la ruta de la imagen correspondiente al Item.
     * */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
