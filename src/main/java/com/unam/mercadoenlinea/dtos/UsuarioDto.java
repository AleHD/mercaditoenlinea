package com.unam.mercadoenlinea.dtos;

public class UsuarioDto {

    public String username;
    public String nombre;
    public String correo;
    public String telefono;
    public boolean comprador;
    public boolean vendedor;
    public String contrasenia;

    public UsuarioDto() {}

    public UsuarioDto(String username, String nombre, String correo, String telefono, boolean comprador, boolean vendedor, String contrasenia) {
        this.username = username;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.contrasenia = contrasenia;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isComprador() {
        return comprador;
    }

    public void setComprador(boolean comprador) {
        this.comprador = comprador;
    }

    public boolean isVendedor() {
        return vendedor;
    }

    public void setVendedor(boolean vendedor) {
        this.vendedor = vendedor;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
