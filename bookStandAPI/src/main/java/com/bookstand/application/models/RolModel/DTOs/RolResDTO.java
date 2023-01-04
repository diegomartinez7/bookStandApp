package com.bookstand.application.models.RolModel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RolResDTO {
    private Long id;
    private String nombre;

    public RolResDTO(String nombre) {
        this.nombre = nombre;
    }
}
