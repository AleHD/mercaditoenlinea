package com.unam.mercadoenlinea;

import com.unam.mercadoenlinea.controller.MercadoEnLineaController;
import com.unam.mercadoenlinea.dtos.LoginDto;
import com.unam.mercadoenlinea.dtos.OpinionDto;
import com.unam.mercadoenlinea.dtos.ProductoDto;
import com.unam.mercadoenlinea.dtos.UsuarioDto;
import com.unam.mercadoenlinea.entities.Opinion;
import com.unam.mercadoenlinea.entities.Producto;
import com.unam.mercadoenlinea.entities.Usuario;
import com.unam.mercadoenlinea.repository.IOpinionRepository;
import com.unam.mercadoenlinea.repository.IProductoRepository;
import com.unam.mercadoenlinea.repository.IUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class MercadoenlineaApplicationTests {

	@Autowired
	private MercadoEnLineaController controller;
	@Autowired
	IUsuarioRepository usuarioRepository;
	@Autowired
	IProductoRepository productoRepository;
	@Autowired
	IOpinionRepository opinionRepository;

	@Test
	void contextLoads() {
	}

	/* Inicia pruebas de Registrar Perfil */

	@Test
	void registrarPerfilN1() throws MessagingException {
		UsuarioDto usr = new UsuarioDto(
				"braulio214", "braulio124@gmail.com", "55 2565 4878",
				true, false
		);
		ResponseEntity<?> res = controller.newUser(usr);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(!code.isError(), "Register failed");

		Usuario match = usuarioRepository.findByCorreo(usr.getCorreo());
		Assert.isTrue(match.getUsername().equals(usr.getUsername()), "Register DB Failed");
	}

	@Test
	void registrarPerfilA2_1() throws MessagingException {
		UsuarioDto usr = new UsuarioDto(
				"braulio214", "braulio124@gmail.com", "55 256h 4878",
				true, false
		);
		ResponseEntity<?> res = controller.newUser(usr);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid phone");
	}

	@Test
	void registrarPerfilA2_2() throws MessagingException {
		UsuarioDto usr = new UsuarioDto(
				"braulio214", "braulio124@gmail.com", "55 25 4878",
				true, false
		);
		ResponseEntity<?> res = controller.newUser(usr);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid phone");
	}

	/* Inicia pruebas de Iniciar Sesión */

	@Test
	void iniciarSesionN1() {
		LoginDto logdto = new LoginDto("braulio124@gmail.com", "GDAG7JQm0bbptcVn");
		ResponseEntity<?> res = controller.login(logdto);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(!code.isError(), "Login failed");
	}

	@Test
	void iniciarSesionA1() {
		LoginDto logdto = new LoginDto("3rgu3z", "Hola123?");
		ResponseEntity res = controller.login(logdto);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError());
	}

	@Test
	void iniciarSesionA2() {
		LoginDto logdto = new LoginDto("erick.erc@ciencias.unam.mx", "Hola345?");
		ResponseEntity res = controller.login(logdto);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError());
	}

	/* Inicia pruebas de Crear Producto */

	@Test
	void crearProductoN1() throws IOException {
		ProductoDto prod = new ProductoDto(
				"Lentes", "Gafas de sol, negras con vidrio protector UV",
				"https://pngimage.net/wp-content/uploads/2018/06/lentes-negros-png-1.png",
				2000L, 0L
		);
		ResponseEntity<?> res = controller.newProduct(prod);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(!code.isError(), "New Product Failed");

		List<Producto> match = productoRepository.findByTitulo(prod.getTitulo());
		Assert.isTrue(!match.isEmpty(), "New Product DB failed");
	}

	@Test
	void crearProductoE1() throws IOException {
		ProductoDto prod = new ProductoDto(
				"12", "Gafas de sol, negras con vidrio protector UV",
				"https://pngimage.net/wp-content/uploads/2018/06/lentes-negros-png-1.png",
				2000L, 0L
		);
		ResponseEntity<?> res = controller.newProduct(prod);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid title");
	}

	@Test
	void crearProductoE2() throws IOException {
		ProductoDto prod = new ProductoDto(
				"Lentes", "1212",
				"https://pngimage.net/wp-content/uploads/2018/06/lentes-negros-png-1.png",
				2000L, 0L
		);
		ResponseEntity<?> res = controller.newProduct(prod);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(code.isError(), "Should reject invalid description");
	}

	/* Inicia pruebas de Actualizar Producto */
	/* Son las mismas que Crear Producto */

	/* Inicia pruebas de Buscar Producto */

	@Test
	void buscarProductoN1() {
		ResponseEntity res = controller.productByKeywordTitle("Lentes");
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(!code.isError(), "Product by keyword failed");
	}

	/* Inicia pruebas de Revisar Opiniones */

	@Test
	void calificarProductoN1() throws IOException {
		OpinionDto op = new OpinionDto(
				"Muy buen producto", "La mesa es muy resistente y de buen material",
				5L, 1L
		);
		ResponseEntity res = controller.postOpinion(op);
		HttpStatus code = res.getStatusCode();
		Assert.isTrue(!code.isError(), "Post opinion failed");

		List<Opinion> match = opinionRepository.findByForeignKey(op.getFk());
		Assert.isTrue(!match.isEmpty(), "New opinion DB failed");
	}
}