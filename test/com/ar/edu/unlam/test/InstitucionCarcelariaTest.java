package com.ar.edu.unlam.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ar.edu.unlam.data.model.InstitucionCarcelaria;

public class InstitucionCarcelariaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//GIVEN
	String nombre = "El silencio";
		//WHEN
	InstitucionCarcelaria ic = new InstitucionCarcelaria(nombre);
		//THEN
		assertNotNull(ic);
	}


}
