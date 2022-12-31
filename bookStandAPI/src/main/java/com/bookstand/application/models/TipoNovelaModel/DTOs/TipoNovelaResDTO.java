package com.bookstand.application.models.TipoNovelaModel.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TipoNovelaResDTO {
    private Long id;
    private String nombre;

    public TipoNovelaResDTO(String nombre) {
        this.nombre = nombre;
    }
}
