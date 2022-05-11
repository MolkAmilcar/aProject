package com.ufro.aProject.model;

import javax.persistence.*;

/**
 * Esta clase se emplea para contener y generar nombres aleatorios para los comentarios.
 *
 * @author Amilcar Celis Aguilar
 */

@Entity
public class Nombre{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "primer_nombre", nullable = false, length = 80)
    private String primerNombre;

    @Column(name = "segundo_nombre", nullable = false, length = 80)
    private String segundoNombre;

    /**
     * Este constructor está vacío y se usa para instanciar un Nombre sin valores.
     */
    public Nombre() {
    }

    /**
     * Este constructor se emplea para determinar el nombre completo en base a la union entre un primer nombre y un segundo nombre calificativo.
     *
     * @param primerNombre El primer nombre de la conjugación (sustantivo).
     * @param segundoNombre El segundo nombre de la conjugación (adjetivo).
     */
    public Nombre(String primerNombre, String segundoNombre) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
    }

    /**
     * @return Devuelve el primer nombre del nombre en conjunto.
     * */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * @param primerNombre Cambia el primer nombre del nombre en conjunto.
     * */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * @return Devuelve el segundo nombre del nombre en conjunto.
     * */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * @param segundoNombre Cambia el segundo nombre del nombre en conjunto.
     * */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
}
