package com.unam.mercadoenlinea.entities;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "titulo")
    private String titulo;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "foto")
    private byte foto;

    @Column(name = "precio")
    private Long precio;

    //My fk

    public Producto(){}

    public Producto(Long id, String descripcion, String titulo, byte foto, Long precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.foto = foto;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
