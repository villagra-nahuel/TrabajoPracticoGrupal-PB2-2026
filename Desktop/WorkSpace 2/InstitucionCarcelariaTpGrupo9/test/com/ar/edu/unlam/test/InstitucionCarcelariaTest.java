package com.ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.ar.edu.unlam.data.model.BuenaConducta;
import com.ar.edu.unlam.data.model.CentroPenitenciario;
import com.ar.edu.unlam.data.model.Delito;
import com.ar.edu.unlam.data.model.EventoDisciplinario;
import com.ar.edu.unlam.data.model.Persona;
import com.ar.edu.unlam.data.model.Recluso;
import com.ar.edu.unlam.data.model.Sancion;

public class InstitucionCarcelariaTest {

	private CentroPenitenciario cp;

	@Before
	public void setUp() throws Exception {
		cp = new CentroPenitenciario("Amanecer");
	}

	@Test
	public void debeCrearUnaCarcel() {
		// GIVEN
		String nombre = "El silencio";
		// WHEN
		CentroPenitenciario ic = new CentroPenitenciario(nombre);
		// THEN
		assertNotNull(ic);
		//hhhhhh
	}

	@Test
	public void debeCrearUnaInstanciaDeReclusoHeredadaDePersona() {

		// GIVEN
		Integer dni = 12;
		String nombre = "nombre";
		String apellido = "apellido";
		LocalDate fdn = LocalDate.of(2026, 01, 01);
		Double condenaBase = 25.0;
		Delito delito = Delito.HURTO_AGRAVADO;

		// WHEN

		Persona recluso = new Recluso(dni, nombre, apellido, fdn, condenaBase, delito);

		Recluso r = (Recluso) recluso;
		r.agregarDelito(Delito.ASESINATO);
		r.agregarDelito(Delito.ASESINATO);

		EventoDisciplinario ed = new Sancion("Amotinamiento", LocalDate.of(2025, 02, 04));
		EventoDisciplinario ed2 = new BuenaConducta("Horas extra en trabajos de limpieza por un mes",
				LocalDate.of(2025, 02, 04));
		EventoDisciplinario ed3 = new BuenaConducta("Horas extra en trabajos de limpieza por un mes",
				LocalDate.of(2025, 05, 04));

		r.agregarEventoDisciplinario(ed);
		r.agregarEventoDisciplinario(ed2);
		r.agregarEventoDisciplinario(ed3);

		// THEN
		assertNotNull(recluso);
		assertEquals(3, r.getDelitos().size());
		assertTrue(r.getHistorialDisciplinario().contains(ed));
		assertEquals(3, r.getHistorialDisciplinario().size());
		assertEquals(1, r.getSanciones().size());
		assertEquals(2, r.getBuenaConducta().size());
	}

	@Test
	public void debeCrearUnaInstanciaDeReclusoHeredadaDePersonaAgregarlaAlCentroPenitenciarioYEvitarLosDuplicados() {

		// GIVEN
		Integer dni = 12;
		String nombre = "nombre";
		String apellido = "apellido";
		LocalDate fdn = LocalDate.of(2026, 01, 01);
		Double condenaBase = 25.0;
		Delito delito = Delito.HURTO_AGRAVADO;

		Persona recluso = new Recluso(dni, nombre, apellido, fdn, condenaBase, delito);
		Persona recluso2 = new Recluso(13, nombre, apellido, fdn, condenaBase, delito);

		// WHEN
		cp.registrarRecluso(recluso, condenaBase, delito);
		cp.registrarRecluso(recluso, condenaBase, delito);
		cp.registrarRecluso(recluso2, condenaBase, delito);

		// THEN
		assertTrue(cp.getListaDeReclusos().contains(recluso));
		assertEquals(2, cp.getListaDeReclusos().size());
	}

}


//•	Registro de reclusos y control de duplicados.
//•	Registro de familiares y autorización con parentesco.
//•	Intento de autorizar un familiar no registrado.
//•	Solicitud de turno con familiar autorizado y no autorizado.
//•	Control de cupo diario máximo de visitas.
//•	Intento de doble turno al mismo recluso en el mismo día.
//•	Procesamiento de turno con guardia asignado automáticamente.
//•	Procesamiento de turno con guardia indicado y sin disponibilidad.
//•	Flujo completo de un turno: APROBADA → COMPLETADA.
//•	Cálculo de condena con sanciones y buenas conductas.
//•	Validación de ordenamiento cronológico en TreeSet de turnos y registros disciplinarios.
//•	Consulta de historial de visitas por recluso.
//•	Consulta de agenda diaria ordenada por hora

//Clases de soporte
//•	RegistroDisciplinario (abstracta) Posee fecha y descripcion. Es comparable por fecha para permitir ordenamiento cronológico.
//•	Sancion — cada cierta cantidad aumenta la condena.
//•	BuenaConducta — reduce la condena según reglas definidas.
