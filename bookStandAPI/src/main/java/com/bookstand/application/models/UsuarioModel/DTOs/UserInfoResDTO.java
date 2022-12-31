package com.bookstand.application.models.UsuarioModel.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResDTO {
    private Long id;
    //VER SI SE AGREGA EL NOMBRE
	private String username;
	private String email;
	private List<String> roles;
}
