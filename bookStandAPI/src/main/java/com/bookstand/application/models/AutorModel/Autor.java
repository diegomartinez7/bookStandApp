package com.bookstand.application.models.AutorModel;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bookstand.application.models.LibroModel.Libro;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nombre;
    private String seudonimo;
    private String pais;
    private String anio_nacimiento;
    @Column(length = 550)
    private String descripcion;
    private byte[] imagen;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Libro> libros;

    public Autor() {
    }

    public Autor(String nombre, String seudonimo, String pais, String anio_nacimiento, String descripcion,
        byte[] imagen) {
        this.nombre = nombre;
        this.seudonimo = seudonimo;
        this.pais = pais;
        this.anio_nacimiento = anio_nacimiento;
        this.descripcion = descripcion;
        this.imagen = imagen;
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

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnio_nacimiento() {
        return anio_nacimiento;
    }

    public void setAnio_nacimiento(String anio_nacimiento) {
        this.anio_nacimiento = anio_nacimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    //Helpers

    /*public void addJugadorPropio(JugadorPropio jugador) {
        this.jugadoresPropio.add(jugador);
        jugador.getEquipos().add(this);
    }
  
    public void removeJugadorPropio(JugadorPropio jugador) {
        this.jugadoresPropio.remove(jugador);
        jugador.getEquipos().remove(this);
    }

    public void addJugadorContrario(JugadorContrario jugador) {
        this.jugadoresContrario.add(jugador);
        jugador.getEquipos().add(this);
    }
  
    public void removeJugadorContrario(JugadorContrario jugador) {
        this.jugadoresContrario.remove(jugador);
        jugador.getEquipos().remove(this);
    }*/
}
