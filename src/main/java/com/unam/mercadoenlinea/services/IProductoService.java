package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.ProductoDto;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface IProductoService {
    boolean saveProducto(ProductoDto productoDto) throws IOException;
    List<ProductoDto> listAll();
    boolean updateProducto(ProductoDto productoDto) throws IOException;
    boolean deleteProducto(Long id) throws IOException;
    List<ProductoDto> productsBySeller(Long id);
    List<ProductoDto> byKeywordTitle(String keyword);
    ProductoDto byId(Long id);
    boolean compra(String correocomprador, String correovendedor, Long idproducto) throws MessagingException;
}
