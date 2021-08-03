package com.unam.mercadoenlinea;

import com.unam.mercadoenlinea.controller.MercadoEnLineaController;
import com.unam.mercadoenlinea.dtos.UsuarioDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class MercadoenlineaApplicationTests {

	/* Guardo el controlador y lo hago @Autowired para poderlo usar en las
	 + pruebas */
	@Autowired
	private MercadoEnLineaController controller;

	@Test
	void contextLoads() {
	}

	@Test
	void RegistrarPerfilN1() {
		UsuarioDto usr = new UsuarioDto(
			"braulio214", "Braulio", "braulio124@gmail.com", "55 2565 4878",
			true, false, "xdxdxd"
		);
		controller.new_user(usr);
	}

}
