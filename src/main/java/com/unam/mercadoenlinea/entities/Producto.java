package com.unam.mercadoenlinea.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
@Data
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
    private String foto;

    @Column(name = "precio")
    private Long precio;

    //My fk
    @ManyToOne
    @JoinColumn(name = "usuariousuarioid")
    private Usuario usuario;

    //I'm a foreign key on...
    @OneToMany(mappedBy = "producto")
    private List<Opinion> opinions;

    public Producto() {
    }

    // with id
    public Producto(Long id, String descripcion, String titulo, String foto, Long precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.foto = foto;
        this.precio = precio;
    }

    // without id
    public Producto(String descripcion, String titulo, String foto, Long precio, Usuario usuario) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.foto = foto;
        this.precio = precio;
        this.usuario = usuario;
    }
}
