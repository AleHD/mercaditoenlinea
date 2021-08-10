package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.LoginDto;
import com.unam.mercadoenlinea.dtos.UsuarioDto;

public interface IUsuarioService {
	Boolean saveUsuario(UsuarioDto usuarioDto);
	UsuarioDto access(LoginDto loginDto);
	UsuarioDto findById(Long id);
}
