package com.bookstand.application.models.LibroModel;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.bookstand.application.models.AutorModel.Autor;
import com.bookstand.application.models.DetalleCompraModel.DetalleCompra;
import com.bookstand.application.models.EditorialModel.Editorial;
import com.bookstand.application.models.LibroImagenModel.LibroImagen;
import com.bookstand.application.models.ProveedorModel.Proveedor;
import com.bookstand.application.models.RegistroInventarioModel.RegistroInventario;
import com.bookstand.application.models.TipoNovelaModel.TipoNovela;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = true)
    private String isbn;
    @NotBlank
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_editorial", nullable = false)
    @JsonBackReference
    private Editorial editorial;  //private Long id_editorial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_autor", nullable = false)
    @JsonBackReference
    private Autor autor;  //private Long id_autor;

    private String empastado;
    private String categoria;
    private Integer no_paginas;
    private String idioma;
    private String anio;
    @Column(length = 600)
    private String sinopsis;
    @Min(0)
    private double precio;

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<LibroImagen> imagenes;

    @ManyToMany
    @JoinTable(
        name = "libro_novela",
        joinColumns = @JoinColumn(name = "id_libro", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_tipo_novela", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("libros")
    private Set<TipoNovela> tiposNovela;

    @ManyToMany(mappedBy = "libros")
    @JsonIgnoreProperties("libros")
    private Set<Proveedor> proveedores;

    @OneToMany(mappedBy = "libro", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<RegistroInventario> inventario;

    @OneToMany(mappedBy = "libro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<DetalleCompra> detalles;

    public Libro() {
    }

    public Libro(String isbn, String titulo, Editorial editorial, Autor autor, String empastado, String categoria,
        Integer no_paginas, String idioma, String anio, String sinopsis, double precio, Set<LibroImagen> imagenes,
        Set<TipoNovela> tiposNovela) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.autor = autor;
        this.empastado = empastado;
        this.categoria = categoria;
        this.no_paginas = no_paginas;
        this.idioma = idioma;
        this.anio = anio;
        this.sinopsis = sinopsis;
        this.precio = precio;
        this.imagenes = imagenes;
        this.tiposNovela = tiposNovela;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEmpastado() {
        return empastado;
    }

    public void setEmpastado(String empastado) {
        this.empastado = empastado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getNo_paginas() {
        return no_paginas;
    }

    public void setNo_paginas(Integer no_paginas) {
        this.no_paginas = no_paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Set<LibroImagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Set<LibroImagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Set<TipoNovela> getTiposNovela() {
        return tiposNovela;
    }

    public void setTiposNovela(Set<TipoNovela> tiposNovela) {
        this.tiposNovela = tiposNovela;
    }

    public Set<RegistroInventario> getInventario() {
        return inventario;
    }

    public void setInventario(Set<RegistroInventario> inventario) {
        this.inventario = inventario;
    }

    public Set<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        // return "LibroModel [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", editorial=" + editorial
        //         + ", autor=" + autor + ", empastado=" + empastado + ", categoria=" + categoria + ", no_paginas="
        //         + no_paginas + ", idioma=" + idioma + ", anio=" + anio + ", sinopsis=" + sinopsis + ", precio=" + precio
        //         + "]";

        return "\n\nLibro" +
        "\nID: " + id +
        "\nISBN: " + isbn +
        "\nTítulo: " + titulo +
        "\nEditorial: " + editorial.getNombre() +
        "\nAutor: " + autor.getNombre() +
        "\nEmpastado: " + empastado +
        "\nCategoría: " + categoria +
        "\nNo. páginas: " + no_paginas +
        "\nIdioma: " + idioma +
        "\nAño de publicación: " + anio +
        "\nSinopsis: " + sinopsis +
        "\nPrecio: $" + precio + "\n\n";
    }

    //Helpers

    public void addTipoNovela(TipoNovela tipoNovela) {
        if(tipoNovela != null){
            this.tiposNovela.add(tipoNovela);
            tipoNovela.getLibros().add(this);
        }
    }
  
    public void removeTipoNovela(TipoNovela tipoNovela) {
        if(tipoNovela != null){
            this.tiposNovela.remove(tipoNovela);
            tipoNovela.getLibros().remove(this);
        }
    }
}
