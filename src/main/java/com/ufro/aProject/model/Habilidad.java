package com.ufro.aProject.model;

import javax.persistence.*;

/**
 * Esta clase almacena corresponde a las habilidades con las que los personajes cuentan y muestran en su detalle de personaje.
 *
 * @author Amilcar Celis
 */

@Entity
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "enfriamiento", nullable = false)
    private Long enfriamiento;

    /**
     * Este constructor está vacío y se usa para instanciar una habilidad sin valores.
     */
    public Habilidad() {}

    /**
     * Este constructor genera un comentario determinando su fecha, mensaje del contenido del comentario y el nombre del autor.
     *
     * @param id El numero identificador de la habilidad.
     * @param nombre El nombre de la habilidad.
     * @param descripcion La descripción de las características de la habilidad.
     * @param enfriamiento El tiempo de espera que tiene la habilidad posterior a su uso.
     */
    public Habilidad(Long id, String nombre, String descripcion, Long enfriamiento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enfriamiento = enfriamiento;
    }

    /**
     * @return Devuelve el id de la habilidad.
     * */
    public Long getId() {
        return id;
    }

    /**
     * @param id Cambia el id de la habilidad.
     * */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Devuelve el nombre de la habilidad.
     * */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Cambia el nombre de la habilidad.
     * */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Devuelve la descripcion de la habilidad.
     * */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Cambia la descripcion de la habilidad.
     * */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Devuelve el enfriamiento de la habilidad.
     * */
    public Long getEnfriamiento() {
        return enfriamiento;
    }

    /**
     * @param enfriamiento Cambia el enfriamiento de la habilidad.
     * */
    public void setEnfriamiento(Long enfriamiento) {
        this.enfriamiento = enfriamiento;
    }
}
