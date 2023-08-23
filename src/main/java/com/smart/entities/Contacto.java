package com.smart.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	
	private String nombre;
	
	private String apellidos;
	
	private String trabajo;
	
	private String email;
	
	private String telefono;
	
	private String image;
	
	@Column(length = 50000)
	private String descripcion;
	
	@ManyToOne
	private Usuario usuario;
	
	

	public Contacto(int cId, String nombre, String apellidos, String trabajo, String email, String telefono,
			String image, String descripcion, Usuario usuario) {
		super();
		this.cId = cId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.trabajo = trabajo;
		this.email = email;
		this.telefono = telefono;
		this.image = image;
		this.descripcion = descripcion;
		this.usuario = usuario;
	}

	public Contacto(int cId, String nombre, String apellidos, String trabajo, String email, String telefono,
			String image, String descripcion) {
		super();
		this.cId = cId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.trabajo = trabajo;
		this.email = email;
		this.telefono = telefono;
		this.image = image;
		this.descripcion = descripcion;
	}

	public Contacto(String nombre, String apellidos, String trabajo, String email, String telefono, String image,
			String descripcion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.trabajo = trabajo;
		this.email = email;
		this.telefono = telefono;
		this.image = image;
		this.descripcion = descripcion;
	}

	public Contacto() {
		super();
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	


	
	
	

}
