package com.ufro.aProject.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Locale;

@Entity
public class ComentarioItem {
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
    @JoinColumn(name="item_id")
    private Item item;

    //constructores, getters y setters
    public ComentarioItem() {
    }

    //TODO crear metodo que genera nombres aleatorios
    public ComentarioItem(Timestamp fecha, String mensaje, String nombre) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormatDate() {
        return DateFormat
                // obtiene una instancia de fecha y hora actual con los formatos dados y en el formato de Locale (es CL)
                .getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, new Locale("es", "CL"))
                // Locale generalmente no es necesario, se agrega en caso de que el sistema que ejecuta la aplicación
                // tenga un lenguaje y país distinto al deseado (inglés p.ej.)
                .format(getFecha());
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


}
