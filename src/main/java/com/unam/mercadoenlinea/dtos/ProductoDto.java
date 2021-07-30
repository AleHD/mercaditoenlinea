package com.unam.mercadoenlinea.dtos;

import com.unam.mercadoenlinea.entities.Producto;

import javax.persistence.*;

public class ProductoDto {

    public String descripcion;
    public String titulo;
    public byte foto;
    public Long precio;

    public ProductoDto(){}

    public ProductoDto(String descripcion, String titulo, byte foto, Long precio) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.foto = foto;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte getFoto() {
        return foto;
    }

    public void setFoto(byte foto) {
        this.foto = foto;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
