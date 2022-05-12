package com.ufro.aProject.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Locale;

/**
 * Esta clase contiene y almacena la información de los comentarios correspondientes a los personajes.
 *
 * @author Amilcar Celis, Isidora Albayay
 */

@Entity
public class ComentarioPersonaje {

    //columnas
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
    @JoinColumn(name="personaje_id")
    private Personaje personaje;

    /**
     * Este constructor está vacío y se usa para instanciar un comentario sin valores.
     */
    //constructores, getters y setters
    public ComentarioPersonaje() {
    }

    /**
     * Este constructor genera un comentario determinando su fecha, mensaje del contenido del comentario y el nombre del autor.
     *
     * @param fecha La fecha del comentario.
     * @param mensaje El mensaje del comentario.
     * @param nombre El nombre del autor del comentario.
     */
    public ComentarioPersonaje( Timestamp fecha, String mensaje, String nombre) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.nombre = nombre;
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
     * Este metodo agrega un producto al carrito del cliente
     * @return Devuelve los datos de la fecha en el instante en que el comentario es creado, y define su formato.
     * */
    public String getFormatDate() {
        return DateFormat
                // obtiene una instancia de fecha y hora actual con los formatos dados y en el formato de Locale (es CL)
                .getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, new Locale("es", "CL"))
                // Locale generalmente no es necesario, se agrega en caso de que el sistema que ejecuta la aplicación
                // tenga un lenguaje y país distinto al deseado (inglés p.ej.)
                .format(getFecha());
    }

    /**
     * @return Devuelve la referencia al personaje al cual corresponde el comentario.
     * */
    public Personaje getPersonaje() {
        return personaje;
    }

    /**
     * @param personaje Cambia el personaje al cual corresponde el comentario.
     * */
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}
