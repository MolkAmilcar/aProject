package com.ufro.aProject.model;

import javax.persistence.*;
import java.util.List;

/**
 * Esta clase se emplea para determinar las características y valores de los atributos de un Item.
 *
 * @author Amilcar Celis, Isidora Albayay
 */
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
    private int armadura;

    @Column(name = "evasion", nullable = false)
    private int evasion;

    @Column(name = "sigilo", nullable = false)
    private int sigilo;


    // clave foranea

    @ManyToMany
    @JoinTable(name = "personaje_habilidades", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "habilidad_id"))
    private List<Habilidad> habilidades;

    //constructores, getters y setters

    /**
     * Este constructor está vacío y se usa para instanciar un Personaje sin valores.
     */
    public Personaje() {
    }

    /**
     * Este constructor se emplea para determinar las características y valores de los atributos de un Personaje.
     *
     * @param nombre El nombre del Personaje.
     * @param descripcion La descripción de las características del Personaje.
     * @param vida La cantidad de puntos de vida del Personaje.
     * @param daño La cantidad de puntos de daño del Personaje.
     * @param velocidad La cantidad de puntos de velocidad del Personaje.
     * @param armadura La cantidad de puntos de armadura del Personaje.
     * @param evasion La cantidad de puntos de evasion del Personaje.
     * @param sigilo La cantidad de puntos de sigilo del Personaje.
     * @param habilidades Las habilidades correspondientes al Personaje.
     */
    public Personaje(String nombre, String descripcion, int vida, int daño, int velocidad, int armadura, int evasion, int sigilo, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vida = vida;
        this.daño = daño;
        this.velocidad = velocidad;
        this.armadura = armadura;
        this.evasion = evasion;
        this.sigilo = sigilo;
        this.habilidades = habilidades;
    }

    /**
     * @return Devuelve el id del Personaje.
     * */
    public Long getId() {
        return id;
    }

    /**
     * @param id Cambia el id del Personaje.
     * */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Devuelve el nombre del Personaje.
     * */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Cambia el nombre del Personaje.
     * */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return Devuelve la descripcion del Personaje.
     * */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion Cambia la descripcion del Personaje.
     * */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Devuelve la cantidad de puntos de vida del Personaje.
     * */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida Cambia la cantidad de puntos de vida del Personaje.
     * */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return Devuelve la cantidad de puntos de daño del Personaje.
     * */
    public int getDaño() {
        return daño;
    }

    /**
     * @param daño Cambia la cantidad de puntos de daño del Personaje.
     * */
    public void setDaño(int daño) {
        this.daño = daño;
    }

    /**
     * @return Devuelve la cantidad de puntos de velocidad del Personaje.
     * */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad Cambia la cantidad de puntos de velocidad del Personaje.
     * */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return Devuelve la cantidad de puntos de armadura del Personaje.
     * */
    public int getArmadura() {
        return armadura;
    }

    /**
     * @param armadura Cambia la cantidad de puntos de armadura del Personaje.
     * */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    /**
     * @return Devuelve la cantidad de puntos de evasion del Personaje.
     * */
    public int getEvasion() {
        return evasion;
    }

    /**
     * @param evasion Cambia la cantidad de puntos de evasion del Personaje.
     * */
    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    /**
     * @return Devuelve la cantidad de puntos de sigilo del Personaje.
     * */
    public int getSigilo() {
        return sigilo;
    }

    /**
     * @param sigilo Cambia la cantidad de puntos de sigilo del Personaje.
     * */
    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }

    /**
     * @return Devuelve la ruta de la imagen del Personaje.
     * */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen Cambia la ruta de la imagen del Personaje.
     * */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return Devuelve la lista de las habilidades del Personaje.
     * */
    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    /**
     * @param habilidades Cambia la lista de las habilidades del Personaje.
     * */
    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

}
