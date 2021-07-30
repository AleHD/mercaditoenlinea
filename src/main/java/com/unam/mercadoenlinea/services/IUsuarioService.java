package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.UsuarioDto;

public interface IUsuarioService {
    Boolean saveUsuario(UsuarioDto usuarioDto);
}
