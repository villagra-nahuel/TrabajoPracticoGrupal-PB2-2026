package com.ar.edu.unlam.data.model;

import java.time.LocalDate;
import java.util.Objects;

public class EventoDisciplinario {

	private String descripcion;
	private LocalDate fechaDelEvento;

	public EventoDisciplinario(String descripcion, LocalDate fechaDelEvento) {
		super();
		this.descripcion = descripcion;
		this.fechaDelEvento = fechaDelEvento;
	}

	public LocalDate getFechaDelEvento() {
		return fechaDelEvento;
	}

	public void setFechaDelEvento(LocalDate fechaDelEvento) {
		this.fechaDelEvento = fechaDelEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaDelEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoDisciplinario other = (EventoDisciplinario) obj;
		return Objects.equals(fechaDelEvento, other.fechaDelEvento);
	}

}
