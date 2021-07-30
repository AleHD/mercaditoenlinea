package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.ProductoDto;

import java.util.List;

public interface IProductoService {
    boolean saveProducto(ProductoDto productoDto);
    List<ProductoDto> listAll();
}
