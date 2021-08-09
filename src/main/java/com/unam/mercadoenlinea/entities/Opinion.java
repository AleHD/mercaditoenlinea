package com.unam.mercadoenlinea.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "opinion")
@Data
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopinion")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "calificacion")
    private Long calificacion;

    // My fk
    @ManyToOne
    @JoinColumn(name = "productoidproducto")
    private Producto producto;

    public Opinion(){}

    public Opinion(String titulo, String descripcion, Long calificacion, Producto producto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.producto = producto;
    }
}
