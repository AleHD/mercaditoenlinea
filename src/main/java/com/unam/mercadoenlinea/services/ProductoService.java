package com.unam.mercadoenlinea.services;

import com.unam.mercadoenlinea.dtos.ProductoDto;
import com.unam.mercadoenlinea.entities.Producto;
import com.unam.mercadoenlinea.entities.Usuario;
import com.unam.mercadoenlinea.repository.IProductoRepository;
import com.unam.mercadoenlinea.repository.IUsuarioRepository;
import com.unam.mercadoenlinea.utils.EnviadorCorreo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    IProductoRepository iProductoRepository;

    @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Override
    public boolean saveProducto(ProductoDto productoDto) throws DataAccessException, IOException {
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

    @Override
    public boolean updateProducto(ProductoDto productoDto) throws IOException{
        Optional<Producto> producto = iProductoRepository.findById(productoDto.getId());
        if(!producto.isPresent()){
            return false;
        }

        Producto p = producto.get();
        p.setDescripcion(productoDto.getDescripcion());
        p.setTitulo(productoDto.getTitulo());
        p.setFoto(productoDto.getFoto());
        p.setPrecio(productoDto.getPrecio());
        iProductoRepository.save(p);
        return true;
    }

    @Override
    public boolean deleteProducto(Long id) throws IOException {
        iProductoRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ProductoDto> productsBySeller(Long id) {
        List<Producto> productos = iProductoRepository.findUsuariousuarioid(id);
        List<ProductoDto> productoDtos = new Vector<>();
        productos.stream().forEach((producto) -> { productoDtos.add(this.entityToDto(producto)); });
        return productoDtos;
    }

    @Override
    public List<ProductoDto> byKeywordTitle(String keyword) {
        List<Producto> productos = iProductoRepository.findAll();
        List<Producto> productos_containkey = new Vector<>();
        productos.stream().forEach((producto) -> { if(producto.getTitulo().contains(keyword)) productos_containkey.add(producto); });

        List<ProductoDto> productoDtos = new Vector<>();
        productos_containkey.stream().forEach((producto) -> { productoDtos.add(this.entityToDto(producto)); });
        return productoDtos;
    }

    @Override
    public ProductoDto byId(Long id) {
        Optional<Producto> producto = iProductoRepository.findById(id);
        ProductoDto productoDto = producto.isPresent()? this.entityToDto(producto.get()) : null;
        return productoDto;
    }

    @Override
    public boolean compra(String correocomprador, String correovendedor, Long idproducto) throws MessagingException{
        Optional<Producto> producto = iProductoRepository.findById(idproducto);
        Usuario comprador = iUsuarioRepository.findByCorreo(correocomprador);
        Usuario vendedor = iUsuarioRepository.findByCorreo(correovendedor);
        if(!producto.isPresent()){
            return false;
        }

        Producto p = producto.get();
        // notificacion a comprador
        EnviadorCorreo.notificacionCompra(correocomprador, comprador.getUsername(), p.getTitulo(), p.getDescripcion(), p.getPrecio().toString(), p.getFoto());
        // notificacion a vendedor
        EnviadorCorreo.notificacionVenta(correovendedor, vendedor.getUsername(), p.getTitulo(), p.getDescripcion(), p.getPrecio().toString(), p.getFoto());

        return true;
    }

    private Producto dtoToEntity(ProductoDto productoDto) throws IOException{
        Optional<Usuario> us = iUsuarioRepository.findById(productoDto.getFk_user());
        Usuario usuario = us.isPresent()? us.get(): null;
        return new Producto(productoDto.getDescripcion(), productoDto.getTitulo(), productoDto.getFoto(), productoDto.getPrecio(), usuario);
    }

    private ProductoDto entityToDto(Producto producto){
        return new ProductoDto(producto.getId(), producto.getTitulo(), producto.getDescripcion(), producto.getFoto(), producto.getPrecio(), producto.getUsuario().getId());
    }
}
