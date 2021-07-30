package com.unam.mercadoenlinea.controller;

import com.unam.mercadoenlinea.dtos.ProductoDto;
import com.unam.mercadoenlinea.dtos.UsuarioDto;
import com.unam.mercadoenlinea.services.IProductoService;
import com.unam.mercadoenlinea.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("mercado-en-linea/")
@RestController
public class MercadoEnLineaController {
    @Autowired
    IUsuarioService iUsuarioService;

    @Autowired
    IProductoService iProductoService;

    @GetMapping("hello_world/")
    public ResponseEntity<?> hello_world(){
        return ResponseEntity.ok().body("Hello World!");
    }

    @PostMapping("new_user/")
    public ResponseEntity<?> new_user(@RequestBody UsuarioDto usuarioDto){
        return ResponseEntity.ok().body(iUsuarioService.saveUsuario(usuarioDto));
    }

    @PostMapping("new_product/")
    public ResponseEntity<?> new_product(@RequestBody ProductoDto productoDto){
        return ResponseEntity.ok().body(iProductoService.saveProducto((productoDto)));
    }

    @GetMapping("all_products/")
    public ResponseEntity<?> all_products(){
       return ResponseEntity.ok().body(iProductoService.listAll());
    }

    //Delete product

    //update product
}
