package com.ar.edu.unlam.data.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class Recluso extends Persona {
	private Double condenaBase;
	private Double factorConducta;
	private HashSet<EventoDisciplinario> historialDisciplinario;
	private ArrayList<Delito> delitos;

	public Recluso(Integer dni, String nombre, String apellido, LocalDate fdn, Double condenaBase, Delito delito) {
		super(dni, nombre, apellido, fdn);
		this.condenaBase = condenaBase;
		this.delitos = new ArrayList<Delito>();
		this.delitos.add(delito);
		this.historialDisciplinario = new HashSet<EventoDisciplinario>();
		this.factorConducta = 1.0;

	}

	public Double getCondenaBase() {
		return condenaBase;
	}

	public void setCondenaBase(Double condenaBase) {
		this.condenaBase = condenaBase;
	}

	public Double getFactorConducta() {
		return factorConducta;
	}

	public void setFactorConducta(Double factorConducta) {
		this.factorConducta = factorConducta;
	}

	public HashSet<EventoDisciplinario> getHistorialDisciplinario() {
		return historialDisciplinario;
	}

	public void agregarEventoDisciplinario(EventoDisciplinario ed) {
		this.historialDisciplinario.add(ed);
	}

	public ArrayList<Delito> getDelitos() {
		return delitos;
	}

	public void agregarDelito(Delito delito) {
		this.delitos.add(delito);
	}

	public ArrayList<Sancion> getSanciones() {

		ArrayList<Sancion> sanciones = new ArrayList<Sancion>();
		for (EventoDisciplinario ed : historialDisciplinario) {
			if (ed instanceof Sancion) {
				sanciones.add((Sancion) ed);
			}
		}

		return sanciones;
	}

	public ArrayList<BuenaConducta> getBuenaConducta() {
		ArrayList<BuenaConducta> sanciones = new ArrayList<BuenaConducta>();
		for (EventoDisciplinario ed : historialDisciplinario) {
			if (ed instanceof BuenaConducta) {
				sanciones.add((BuenaConducta) ed);
			}
		}
		return sanciones;
	}

}
