package com.bookstand.application.models.LibroImagenModel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroImagenReqDTO {
    private Long id_libro;
    private byte[] imagen;
    private String nombre;
    private String extension;
}
