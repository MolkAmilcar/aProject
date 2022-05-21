package com.ufro.aProject.model;

import javax.persistence.*;

@Entity
public class Moderador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "contrasena", nullable = false, length = 80)
    private String constrasena;

    public Moderador(){}

    public Moderador(Long id, String nombre, String constrasena) {
        this.id = id;
        this.nombre = nombre;
        this.constrasena = constrasena;
    }

    public void iniciarSesion(){}

    public void eliminarComentario(int idComentario){}

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

    public String getConstrasena() {
        return constrasena;
    }

    public void setConstrasena(String constrasena) {
        this.constrasena = constrasena;
    }
}
