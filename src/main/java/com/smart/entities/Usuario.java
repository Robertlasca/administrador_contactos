package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nombre;
	@Column(unique=true)
	private String email;
	
	private String pasword;
	
	private String role;
	
	private boolean enabled;
	
	private String imageUrl;
	@Column(length = 500)
	private String about;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Contacto> contactos= new ArrayList<>();
	public Usuario(int id, String nombre, String email, String pasword, String role, boolean enabled, String imageUrl,
			String about) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pasword = pasword;
		this.role = role;
		this.enabled = enabled;
		this.imageUrl = imageUrl;
		this.about = about;
	}
	
	
	public Usuario(String nombre, String email, String pasword, String role, boolean enabled, String imageUrl,
			String about) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.pasword = pasword;
		this.role = role;
		this.enabled = enabled;
		this.imageUrl = imageUrl;
		this.about = about;
	}
	
	


	public Usuario(int id, String nombre, String email, String pasword, String role, boolean enabled, String imageUrl,
			String about, List<Contacto> contactos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pasword = pasword;
		this.role = role;
		this.enabled = enabled;
		this.imageUrl = imageUrl;
		this.about = about;
		this.contactos = contactos;
	}


	public Usuario() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}


	public List<Contacto> getContactos() {
		return contactos;
	}


	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	} 
	
	
	
	
	
	
	
}
