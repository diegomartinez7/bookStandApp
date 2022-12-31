package com.bookstand.application.models.AutorModel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorReqDTO {
    private String nombre;
    private String seudonimo;
    private String pais;
    private String anio_nacimiento;
    private String descripcion;
    private byte[] imagen;
}
