package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class calculadoraTEST {
	
	private CalculadoraDePrimos calculadora = new CalculadoraDePrimos();
	private ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
	
	@Test
	public void testValor90(){
		
		calculadora.calcularPrimos(90);
		
		
		/*
		 * Resultado esperado de la descomposicion de factores primos de 90 es 2 3 3 5
		 */
		
		resultadoEsperado.add(2);
		resultadoEsperado.add(3);
		resultadoEsperado.add(3);
		resultadoEsperado.add(5);
		
		ArrayList<Integer> resultado  = calculadora.getListaDeNumerosPrimos();
		Assert.assertEquals(resultadoEsperado, resultado);
		

	}
	
	@Test
	public void testValor360(){
		
		calculadora.calcularPrimos(360);
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		resultadoEsperado.add(3);
		resultadoEsperado.add(3);
		resultadoEsperado.add(5);
		/*
		 * Resultado esperado de la descomposicion de factores primos de 360 es 2 2 2 3 3 5
		 */
		
		ArrayList<Integer> resultado  = calculadora.getListaDeNumerosPrimos();
		Assert.assertEquals(resultadoEsperado, resultado);
	}
	
}
