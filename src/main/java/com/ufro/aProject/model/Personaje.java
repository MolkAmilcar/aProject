package com.ufro.aProject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Personaje {

    //columnas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "vida", nullable = false)
    private Long vida;

    @Column(name = "daño", nullable = false)
    private Long daño;

    @Column(name = "velocidad", nullable = false)
    private Long velocidad;

    @Column(name = "armadura", nullable = false)
    private Long enfriamiento;

    @Column(name = "evasion", nullable = false)
    private Long evasion;

    @Column(name = "sigilo", nullable = false)
    private Long sigilo;


    // clave foranea

    @ManyToMany
    @JoinTable(name = "personaje_habilidades", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "habilidad_id"))
    private List<Habilidad> habilidades;

    //constructores, getters y setters

    public Personaje() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getVida() {
        return vida;
    }

    public void setVida(Long vida) {
        this.vida = vida;
    }

    public Long getDaño() {
        return daño;
    }

    public void setDaño(Long daño) {
        this.daño = daño;
    }

    public Long getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Long velocidad) {
        this.velocidad = velocidad;
    }

    public Long getEnfriamiento() {
        return enfriamiento;
    }

    public void setEnfriamiento(Long enfriamiento) {
        this.enfriamiento = enfriamiento;
    }

    public Long getEvasion() {
        return evasion;
    }

    public void setEvasion(Long evasion) {
        this.evasion = evasion;
    }

    public Long getSigilo() {
        return sigilo;
    }

    public void setSigilo(Long sigilo) {
        this.sigilo = sigilo;
    }



}
