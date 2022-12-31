package com.bookstand.application.models.AutorModel.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AutorResDTO {
    private Long id;
    private String nombre;
    private String seudonimo;
    private String pais;
    private String anio_nacimiento;
    private String descripcion;
    private byte[] imagen;

    public AutorResDTO(String nombre, String seudonimo, String pais, String anio_nacimiento, String descripcion,
        byte[] imagen) {
        this.nombre = nombre;
        this.seudonimo = seudonimo;
        this.pais = pais;
        this.anio_nacimiento = anio_nacimiento;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
}
