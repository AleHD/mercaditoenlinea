package com.unam.mercadoenlinea.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "comprador")
    private boolean comprador;

    @Column(name = "vendedor")
    private boolean vendedor;

    @Column(name = "contrasenia")
    private String contrasenia;

    //I'm foreing key on...

    public Usuario(){}

    public Usuario(Long id, String username, String nombre, String correo, String telefono, boolean comprador, boolean vendedor, String contrasenia) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.contrasenia = contrasenia;
    }


}
