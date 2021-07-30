package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.UsuarioDto;
import com.unam.mercadoenlinea.entities.Usuario;
import com.unam.mercadoenlinea.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public Boolean saveUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = this.dtoToentity(usuarioDto);
        usuarioRepository.save(usuario);
        return true;
    }

    private Usuario dtoToentity(UsuarioDto usuarioDto){
    return new Usuario(new Long(1), usuarioDto.getUsername(), usuarioDto.getNombre(), usuarioDto.getCorreo(), usuarioDto.getTelefono(), usuarioDto.comprador, usuarioDto.vendedor, usuarioDto.getContrasenia());
    }

}
