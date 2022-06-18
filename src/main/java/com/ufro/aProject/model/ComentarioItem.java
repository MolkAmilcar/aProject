package com.ufro.aProject.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Locale;

/**
 * Esta clase contiene y almacena la información de los comentarios correspondientes a los items.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
@Entity
public class ComentarioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha")
    private Timestamp fecha;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    /**
     * Este constructor está vacío y se usa para instanciar un comentario sin valores.
     */
    public ComentarioItem() {
    }

    /**
     * Este constructor genera un comentario determinando su fecha, mensaje del contenido del comentario y el nombre del autor.
     *
     * @param fecha La fecha del comentario.
     * @param mensaje El mensaje del comentario.
     * @param nombre El nombre del autor del comentario.
     */
    public ComentarioItem(Timestamp fecha, String mensaje, String nombre, Long id) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.id=id;
    }

    /**
     * @return Devuelve el id del comentario.
     * */
    public Long getId() {
        return id;
    }

    /**
     * @param id Cambia el id del comentario.
     * */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Devuelve la fecha del comentario.
     * */
    public Timestamp getFecha() {
        return fecha;
    }

    /**
     * @param fecha Cambia la fecha del comentario.
     * */
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    /**
     * @return Devuelve el mensaje contenido en el comentario.
     * */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje Cambia el mensaje contenido en el comentario.
     * */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return Devuelve el nombre del autor del comentario.
     * */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Cambia el nombre del autor del comentario.
     * */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo obtiene la fecha actual local y la devuelve.
     * @return Devuelve los datos de la fecha en el instante en que el comentario es creado, y define su formato.
     * */
    public String getFormatDate() {
        return DateFormat
                .getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, new Locale("es", "CL"))
                .format(getFecha());
    }

    /**
     * @return Devuelve la referencia al item al cual corresponde el comentario.
     * */
    public Item getItem() {
        return item;
    }

    /**
     * @param item Cambia el item al cual corresponde el comentario.
     * */
    public void setItem(Item item) {
        this.item = item;
    }


}
