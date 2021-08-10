package com.unam.mercadoenlinea.controller;

import com.unam.mercadoenlinea.dtos.LoginDto;
import com.unam.mercadoenlinea.dtos.OpinionDto;
import com.unam.mercadoenlinea.dtos.ProductoDto;
import com.unam.mercadoenlinea.dtos.UsuarioDto;
import com.unam.mercadoenlinea.services.IOpinionService;
import com.unam.mercadoenlinea.services.IProductoService;
import com.unam.mercadoenlinea.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("mercado-en-linea/")
@RestController
public class MercadoEnLineaController {
	@Autowired
	IUsuarioService iUsuarioService;

	@Autowired
	IProductoService iProductoService;

	@Autowired
	IOpinionService iOpinionService;

	@GetMapping("hello_world/")
	public ResponseEntity<?> helloWorld(){
		return ResponseEntity.ok().body("Hello World!");
	}

	// registro de un usuario
	@PostMapping("new_user/")
	public ResponseEntity<?> newUser(@RequestBody UsuarioDto usuarioDto){
		return ResponseEntity.ok().body(iUsuarioService.saveUsuario(usuarioDto));
	}

	//ingreso del usuario
	@PostMapping("login/")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
		UsuarioDto usuarioDto = iUsuarioService.access(loginDto);

		if(usuarioDto != null){
			return ResponseEntity.ok().body(usuarioDto);
		}

		return ResponseEntity.badRequest().body("Access Denied");
	}

	// usuario by id
	@GetMapping("user/")
	public ResponseEntity<?> getUser(@RequestParam Long id){
		UsuarioDto usuarioDto = iUsuarioService.findById(id);

		if(usuarioDto != null){
			return ResponseEntity.ok().body(usuarioDto);
		}

		return ResponseEntity.badRequest().body("User not valid");
	}

	// agregar producto
	@PostMapping("new_product/")
	public ResponseEntity<?> newProduct(@RequestBody ProductoDto productoDto) throws IOException {
		return ResponseEntity.ok().body(iProductoService.saveProducto((productoDto)));
	}

	// obtiene todos los productos
	@GetMapping("all_products/")
	public ResponseEntity<?> allProducts(){
	   return ResponseEntity.ok().body(iProductoService.listAll());
	}

	// Todos los productos que oferta el vendedor con cierto fk
	@GetMapping("products_by_seller/")
	public ResponseEntity<?> productsbyseller(@RequestParam Long id){
		return ResponseEntity.ok().body(iProductoService.productsBySeller(id));
	}

	//productos que contengan key en su tìtulo
	@GetMapping("by_keyword/")
	public ResponseEntity<?> productByKeywordTitle(@RequestParam String keyword){
		return ResponseEntity.ok().body(iProductoService.byKeywordTitle(keyword));
	}

	//consultar producto (por id)
	@GetMapping("product_by_id/")
	public ResponseEntity<?> productById(@RequestParam Long id){
		ProductoDto productoDto = iProductoService.byId(id);

		if(productoDto != null){
			return ResponseEntity.ok().body(productoDto);
		}

		return ResponseEntity.badRequest().body("Product Not Found");
	}

	//update product
	@PutMapping("update_product")
	public ResponseEntity<?> updateeProduct(@RequestBody ProductoDto productoDto) throws IOException{
		return ResponseEntity.ok().body(iProductoService.updateProducto(productoDto));
	}

	//Delete product
	@DeleteMapping("delete_product/")
	public ResponseEntity<?> deleteProduct(@RequestParam Long id) throws IOException{
		return ResponseEntity.ok().body(iProductoService.deleteProducto(id));
	}

	//Agregar opinion
	@PostMapping("post_opinion/")
	public ResponseEntity<?> postOpinion(@RequestBody OpinionDto opinionDto) throws IOException{
		return ResponseEntity.ok().body(iOpinionService.saveOpinion(opinionDto));
	}

	//opiniones de un producto en particular
	@GetMapping("opinions_by_product/")
	public ResponseEntity<?> opinionsById(@RequestParam Long fk){
		return ResponseEntity.ok().body(iOpinionService.opinionsById(fk));
	}
}
