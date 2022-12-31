package com.bookstand.application.models.LibroImagenModel.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LibroImagenResDTO {
    private Long id;
    private Long id_libro;
    private byte[] imagen;
    private String nombre;
    private String extension;

    public LibroImagenResDTO(Long id_libro, byte[] imagen, String nombre, String extension) {
        this.id_libro = id_libro;
        this.imagen = imagen;
        this.nombre = nombre;
        this.extension = extension;
    }
}
