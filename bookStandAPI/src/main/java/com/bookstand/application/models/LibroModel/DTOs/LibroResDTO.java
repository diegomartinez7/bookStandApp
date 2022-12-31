package com.bookstand.application.models.LibroModel.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LibroResDTO {
    private Long id;
    private String isbn;
    private String titulo;
    private Long id_editorial;
    private Long id_autor;
    private String empastado;
    private String categoria;
    private Integer no_paginas;
    private String idioma;
    private String anio;
    private String sinopsis;
    private double precio;

    public LibroResDTO(String isbn, String titulo, Long id_editorial, Long id_autor, String empastado, String categoria,
        Integer no_paginas, String idioma, String anio, String sinopsis, double precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.id_editorial = id_editorial;
        this.id_autor = id_autor;
        this.empastado = empastado;
        this.categoria = categoria;
        this.no_paginas = no_paginas;
        this.idioma = idioma;
        this.anio = anio;
        this.sinopsis = sinopsis;
        this.precio = precio;
    }
}
