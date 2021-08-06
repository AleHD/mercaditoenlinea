package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.LoginDto;
import com.unam.mercadoenlinea.dtos.UsuarioDto;
import com.unam.mercadoenlinea.entities.Usuario;
import com.unam.mercadoenlinea.repository.IUsuarioRepository;
import com.unam.mercadoenlinea.utils.EnviadorCorreo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Override
	public Boolean saveUsuario(UsuarioDto usuarioDto) throws DataAccessException, MessagingException {
		Usuario usuario = this.dtoToentity(usuarioDto);
		EnviadorCorreo.sendWelcomeMessage(
			usuario.getUsername(), usuario.getCorreo(), usuario.getContrasenia()
		);
		usuarioRepository.save(usuario);
		return true;
	}

	@Override
	public UsuarioDto access(LoginDto loginDto) {
		Usuario usuario = usuarioRepository.findByCorreoAndContrasenia(loginDto.getCorreo(), loginDto.getContrasenia());
		if(usuario != null){
			return this.entityToDto(usuario);
		}

		return null;
	}

	@Override
	public UsuarioDto findById(Long id) {
		Optional<Usuario> op = usuarioRepository.findById(id);

		if(op.isPresent()){
			Usuario usuario = op.get();
			return this.entityToDto(usuario);
		}

		return null;
	}

	private Usuario dtoToentity(UsuarioDto usuarioDto){
		return new Usuario(usuarioDto.getUsername(), usuarioDto.getCorreo(), usuarioDto.getTelefono(), usuarioDto.comprador, usuarioDto.vendedor);
	}

	private UsuarioDto entityToDto( Usuario usuario){
		return new UsuarioDto(usuario.getId(), usuario.getUsername(), usuario.getCorreo(), usuario.getTelefono(), usuario.isComprador(), usuario.isVendedor());
	}

}