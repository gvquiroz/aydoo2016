package ar.edu.untref.aydoo;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

public class GestorDeFormatosTest {
	@Test
	public void probandoDevolverDatosEnFormatoPretty(){
		ArrayList<Integer> valoresDePrueba = new ArrayList<Integer>();
		valoresDePrueba.add(1);
		valoresDePrueba.add(2);
		valoresDePrueba.add(3);
		String resultadoEsperado = "1 2 3 ";
		
		GestorDeFormatos Formateador = new GestorDeFormatos();
		
		String resultadoActual = Formateador.getDatosConFormato(valoresDePrueba,"Pretty");
		
		Assert.assertEquals(resultadoEsperado,resultadoActual);
	}
	
	@Test
	public void probandoDevolverDatosEnFormaroQuiett(){
		ArrayList<Integer> valoresDePrueba = new ArrayList<Integer>();
		valoresDePrueba.add(1);
		valoresDePrueba.add(2);
		valoresDePrueba.add(3);
		String resultadoEsperado = "1\n2\n3\n";
		
		GestorDeFormatos Formateador = new GestorDeFormatos();
		
		String resultadoActual = Formateador.getDatosConFormato(valoresDePrueba,"Quiett");
		
		Assert.assertEquals(resultadoEsperado,resultadoActual);
	}
}
