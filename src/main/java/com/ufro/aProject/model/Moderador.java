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
}
