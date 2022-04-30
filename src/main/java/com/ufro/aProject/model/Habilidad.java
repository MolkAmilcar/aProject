package com.ufro.aProject.model;

import javax.persistence.*;

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

    public Habilidad() {}

    public Habilidad(Long id, String nombre, String descripcion, Long enfriamiento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enfriamiento = enfriamiento;
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

    public Long getEnfriamiento() {
        return enfriamiento;
    }

    public void setEnfriamiento(Long enfriamiento) {
        this.enfriamiento = enfriamiento;
    }
}
