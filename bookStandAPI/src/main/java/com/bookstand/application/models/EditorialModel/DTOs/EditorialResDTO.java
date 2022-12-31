package com.bookstand.application.models.EditorialModel.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditorialResDTO {
    private Long id;
    private String nombre;
    private String pais;
    private String sitio;  //sitio web oficial
    private byte[] imagen;

    public EditorialResDTO(String nombre, String pais, String sitio, byte[] imagen) {
        this.nombre = nombre;
        this.pais = pais;
        this.sitio = sitio;
        this.imagen = imagen;
    }
}
