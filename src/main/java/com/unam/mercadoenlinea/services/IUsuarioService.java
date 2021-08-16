package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.LoginDto;
import com.unam.mercadoenlinea.dtos.UsuarioDto;

import javax.mail.MessagingException;

public interface IUsuarioService {
    Boolean saveUsuario(UsuarioDto usuarioDto) throws MessagingException;
    UsuarioDto access(LoginDto loginDto);
    UsuarioDto findById(Long id);
}
