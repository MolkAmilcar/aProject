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

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "vida", nullable = false)
    private int vida;

    @Column(name = "daño", nullable = false)
    private int daño;

    @Column(name = "velocidad", nullable = false)
    private int velocidad;

    @Column(name = "armadura", nullable = false)
    private int enfriamiento;

    @Column(name = "evasion", nullable = false)
    private int evasion;

    @Column(name = "sigilo", nullable = false)
    private int sigilo;


    // clave foranea

    @ManyToMany
    @JoinTable(name = "personaje_habilidades", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "habilidad_id"))
    private List<Habilidad> habilidades;

    //constructores, getters y setters

    public Personaje() {
    }

    public Personaje(String nombre, String descripcion, int vida, int daño, int velocidad, int enfriamiento, int evasion, int sigilo, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vida = vida;
        this.daño = daño;
        this.velocidad = velocidad;
        this.enfriamiento = enfriamiento;
        this.evasion = evasion;
        this.sigilo = sigilo;
        this.habilidades = habilidades;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEnfriamiento() {
        return enfriamiento;
    }

    public void setEnfriamiento(int enfriamiento) {
        this.enfriamiento = enfriamiento;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getSigilo() {
        return sigilo;
    }

    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

}
