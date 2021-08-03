package com.unam.mercadoenlinea;

import com.unam.mercadoenlinea.controller.MercadoEnLineaController;
import com.unam.mercadoenlinea.dtos.ProductoDto;
import com.unam.mercadoenlinea.dtos.UsuarioDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest
class MercadoenlineaApplicationTests {

	/* Guardo el controlador y lo hago @Autowired para poderlo usar en las
	 + pruebas */
	@Autowired
	private MercadoEnLineaController controller;

	@Test
	void contextLoads() {
	}

	/* Inicia pruebas de Registrar Perfil */

	@Test
	void registrarPerfilN1() {
		UsuarioDto usr = new UsuarioDto(
			"braulio214", "Braulio", "braulio124@gmail.com", "55 2565 4878",
			true, false, "xdxdxd"
		);
		ResponseEntity<?> res = controller.new_user(usr);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(!code.isError(), "Register failed");
	}

	@Test
	void registrarPerfilA2_1() {
		UsuarioDto usr = new UsuarioDto(
				"braulio214", "Braulio", "braulio@gmail.com", "55 256h 4878",
				true, false, "xdxdxd"
		);
		ResponseEntity<?> res = controller.new_user(usr);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid phone");
	}

	@Test
	void registrarPerfilA2_2() {
		UsuarioDto usr = new UsuarioDto(
				"braulio214", "Braulio", "braulio@gmail.com", "55 25 4878",
				true, false, "xdxdxd"
		);
		ResponseEntity<?> res = controller.new_user(usr);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid phone");
	}

	/* Inicia pruebas de Iniciar Sesión */
	// TODO login API

	@Test
	void iniciarSesionN1() {
		// controller.login("erick.erc@ciencias.unam.mx", "Hola123?");
	}

	@Test
	void iniciarSesionA1() {
		// ResponseEntity res = controller.login("3rgu3z", "Hola123?");
		// HttpStatus code = res.getStatusCode();
		// Assert.isTrue(code.isError());
	}

	@Test
	void iniciarSesionA2() {
		// ResponseEntity res = controller.login("erick.erc@ciencias.unam.mx",
		//                                       "Hola345?");
		// HttpStatus code = res.getStatusCode();
		// Assert.isTrue(code.isError());
	}

	/* Inicia pruebas de Cerrar Sesión */
	// TODO logout API


	/* Inicia pruebas de Crear Producto */

	@Test
	void crearProductoN1() {
		ProductoDto prod = new ProductoDto(
			"Gafas de sol, negras con vidrio protector UV", "Lentes", (byte)0,
			2000L
		);
		ResponseEntity<?> res = controller.new_product(prod);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(!code.isError(), "New Product Failed");
	}

	@Test
	void crearProductoE1() {
		ProductoDto prod = new ProductoDto(
				"Gafas de sol, negras con vidrio protector UV", "121212",
				(byte)0, 2000L
		);
		ResponseEntity<?> res = controller.new_product(prod);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid title");
	}

	@Test
	void crearProductoE2() {
		ProductoDto prod = new ProductoDto(
				"12121212", "Lentes", (byte)0, 2000L
		);
		ResponseEntity<?> res = controller.new_product(prod);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid description");
	}

	/* Inicia pruebas de Actualizar Producto */
	/* Son las mismas que Crear Producto */

	/* Inicia pruebas de Consultar Producto */
	// TODO delete API

	/* Inicia pruebas de Buscar Producto */
	// TODO serach API

	@Test
	void buscarProductoN1() {
		// ResponseEntity res = controller.search_product("libros")
		// HttpStatus code = res.getStatusCode();
		// Assert.isTrue(!code.isError());
	}

	/* Inicia pruebas de Revisar Opiniones */

	/* Inicia pruebas de Comprar Producto */
	// TODO buy API

	@Test
	void comprarProductoN1() {
		// ResponseEntity res = controller.buy_product("braulio@gmail.com",
		//                                             "RanaSaltarina124")
		// HttpStatus code = res.getStatusCode();
		// Assert.isTrue(!code.isError());
	}

	@Test
	void comprarProductoA1() {
		// ResponseEntity res = controller.buy_product("brauliogmail.com",
		//                                             "RanaSaltarina124")
		// HttpStatus code = res.getStatusCode();
		// Assert.isTrue(code.isError());
	}

	/* Inicia pruebas de Calificar Producto */
	// TODO calificar API

	@Test
	void calificarProductoN1() {
		// OpinionDto op = new OpinionDto(
		// 	"Muy buen producto", "La mesa es muy resistente y de buen material",
		// 	5
		// )
		// ResponseEntity res = controller.new_review(op);
		// HttpStatus code = res.getStatusCode();
		// Assert.isTrue(!code.isError());
	}

	@Test
	void comprarProductoA5() {

		// OpinionDto op = new OpinionDto(
		// 	"Muy buen producto", "La mesa es muy resistente y de buen material",
		// 	10
		// )
		// ResponseEntity res = controller.new_review(op);
		// HttpStatus code = res.getStatusCode();
		// Assert.isTrue(code.isError());
	}
}
