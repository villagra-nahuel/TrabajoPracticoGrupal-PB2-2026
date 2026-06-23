package com.ar.edu.unlam.data.model;

import java.time.LocalDate;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private Integer dni;
	private LocalDate fdn;

	public Persona(Integer dni, String nombre, String apellido, LocalDate fdn) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.fdn = fdn;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFdn() {
		return fdn;
	}

	public void setFdn(LocalDate fdn) {
		this.fdn = fdn;
	}
	

}
