package com.unam.mercadoenlinea.entities;

import com.unam.mercadoenlinea.utils.GeneradorContrasenia;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuarioid")
	private Long id;

	@Column(name = "username")
	private String username;

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
	//TODO: adjust fk
	@OneToMany(mappedBy = "usuario")
	private List<Producto> productos;


	public Usuario(){}

	public Usuario(String username, String correo, String telefono, boolean comprador, boolean vendedor) {
		this.username = username;
		this.correo = correo;
		this.telefono = telefono;
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.contrasenia = GeneradorContrasenia.generaContra();
	}
}
