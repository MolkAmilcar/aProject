package com.ufro.aProject.model;

import javax.persistence.*;

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

    public Nombre() {
    }

    public Nombre(String primerNombre, String segundoNombre) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
}
