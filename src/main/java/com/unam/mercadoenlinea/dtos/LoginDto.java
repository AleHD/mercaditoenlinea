package com.unam.mercadoenlinea.dtos;

import lombok.Data;

@Data
public class LoginDto {
	public String correo;
	public String contrasenia;

	public LoginDto(){}

	public LoginDto(String correo, String contrasenia){
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
}
