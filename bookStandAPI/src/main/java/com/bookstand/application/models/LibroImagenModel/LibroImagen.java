package com.bookstand.application.models.LibroImagenModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bookstand.application.models.LibroModel.Libro;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "libro_imagen")
public class LibroImagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_libro", nullable = false)
    @JsonBackReference
    private Libro libro;  // private Long id_libro;

    private byte[] imagen;
    private String nombre;
    private String extension;
    
    public LibroImagen() {
    }

    public LibroImagen(Libro libro, byte[] imagen, String nombre, String extension) {
        this.libro = libro;
        this.imagen = imagen;
        this.nombre = nombre;
        this.extension = extension;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
