package com.ar.edu.unlam.data.model;

import java.util.HashSet;

public class CentroPenitenciario {

	private String nombre;
	private HashSet<Recluso> listaDeReclusos;

	public CentroPenitenciario(String nombre) {
		this.nombre = nombre;
		this.listaDeReclusos = new HashSet<Recluso>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void registrarRecluso(Persona recluso, Double condenaBase, Delito delito) {
		Recluso r = (Recluso) recluso;
		r.setCondenaBase(condenaBase);
		r.agregarDelito(delito);

		listaDeReclusos.add(r);
	}

	public HashSet<Recluso> getListaDeReclusos() {
		return listaDeReclusos;
	}

	
}
