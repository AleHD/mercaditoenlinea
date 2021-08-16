package com.unam.mercadoenlinea.repository;

import com.unam.mercadoenlinea.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCorreoAndContrasenia(String correo, String contrasenia);
    Usuario findByCorreo(String correo);
}
