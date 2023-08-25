package com.smart.helper;

public class Message {
	
	private String contenido;
	private String tipo;
	public Message(String contenido, String tipo) {
		super();
		this.contenido = contenido;
		this.tipo = tipo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	

}
