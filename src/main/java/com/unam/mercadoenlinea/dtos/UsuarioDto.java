package com.unam.mercadoenlinea.dtos;

import lombok.Data;

@Data
public class UsuarioDto {

    public Long id;
    public String username;
    public String correo;
    public String telefono;
    public boolean comprador;
    public boolean vendedor;

    public UsuarioDto() {}

    //TODO: verificar si el usuario existe antes de insertar
    public UsuarioDto(String username, String correo, String telefono, boolean comprador, boolean vendedor) {
        this.username = username;
        this.correo = correo;
        this.telefono = telefono;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }

    public UsuarioDto(Long id, String username, String correo, String telefono, boolean comprador, boolean vendedor) {
        this.id = id;
        this.username = username;
        this.correo = correo;
        this.telefono = telefono;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }
}
