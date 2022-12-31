package com.bookstand.application.models.LibroModel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroReqDTO {
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
}
