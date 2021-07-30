package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.ProductoDto;
import com.unam.mercadoenlinea.entities.Producto;
import com.unam.mercadoenlinea.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    IProductoRepository iProductoRepository;

    @Override
    public boolean saveProducto(ProductoDto productoDto) {
        Producto producto = this.dtoToEntity(productoDto);
        iProductoRepository.save(producto);
        return true;
    }

    @Override
    public List<ProductoDto> listAll() {
        List<Producto> productos = iProductoRepository.findAll();
        List<ProductoDto> productoDtos = new Vector<>();
        productos.stream().forEach((producto) -> { productoDtos.add(this.entityToDto(producto)); });
        return productoDtos;
    }

    private Producto dtoToEntity(ProductoDto productoDto){
        //TODO: arreglar la foto
        return new Producto(new Long(0), productoDto.getDescripcion(), productoDto.getTitulo(), Byte.valueOf("0"), productoDto.getPrecio());
    }

    private ProductoDto entityToDto(Producto producto){
        return new ProductoDto(producto.getDescripcion(), producto.getTitulo(), producto.getFoto(), producto.getPrecio());
    }
}
