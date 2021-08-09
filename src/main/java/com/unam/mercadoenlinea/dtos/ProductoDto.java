package com.unam.mercadoenlinea.dtos;

import com.unam.mercadoenlinea.entities.Producto;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
public class ProductoDto {

    public Long id;
    public String descripcion;
    public String titulo;
    public String foto;
    public Long precio;
    public Long fk_user;

    public ProductoDto(){}

    // with id
    public ProductoDto(Long id, String titulo, String descripcion, String foto, Long precio, Long fk_user) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
        this.precio = precio;
        this.fk_user = fk_user;
    }

    // without id
    public ProductoDto(String titulo, String descripcion, String foto, Long precio, Long fk_user) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
        this.precio = precio;
        this.fk_user = fk_user;
    }
}
