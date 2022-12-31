package com.bookstand.application.models.UsuarioModel.DTOs;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqDTO {
    @NotBlank
	private String username;
	@NotBlank
	private String password;
}
