package com.ufro.aProject.model;

import javax.persistence.*;

/**
 * Esta clase contiene los datos de los moderadores de la página.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
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

    /**
     * Este constructor está vacío y se usa para instanciar un Moderador sin valores.
     */
    public Moderador(){}

    /**
     * Este constructor se emplea para determinar las datos correspondientes a un Moderador.
     *
     * @param id El numero identificador del Moderador.
     * @param nombre El nombre del Moderador.
     * @param constrasena La contrasena de autentificación del Moderador.
     */
    public Moderador(Long id, String nombre, String constrasena) {
        this.id = id;
        this.nombre = nombre;
        this.constrasena = constrasena;
    }

    /**
     * Este metodo le permite iniciar sesion al Moderador.
     * */
    public void iniciarSesion(){}

    /**
     * Este metodo le permite al Moderador eliminar un comentario en base al número de identificación del comentario.
     * @param idComentario El número de indentificacion del comentario.
     * */
    public void eliminarComentario(int idComentario){}
}
