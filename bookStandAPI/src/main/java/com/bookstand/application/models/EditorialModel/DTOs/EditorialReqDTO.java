package com.bookstand.application.models.EditorialModel.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditorialReqDTO {
    private String nombre;
    private String pais;
    private String sitio;  //sitio web oficial
    private byte[] imagen;
}
