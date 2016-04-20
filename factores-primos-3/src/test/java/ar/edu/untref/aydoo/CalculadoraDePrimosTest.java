package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraDePrimosTest {
	
	
	@Test
	public void probandoResultadoIngresandoValor90(){
		CalculadoraDePrimos calculadora = new CalculadoraDePrimos();
		ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
		
		resultadoEsperado.add(2);
		resultadoEsperado.add(3);
		resultadoEsperado.add(3);
		resultadoEsperado.add(5);
		
		calculadora.calcularPrimos(90);

		ArrayList<Integer> resultado  = calculadora.getListaDeNumerosPrimos("asc");
		Assert.assertEquals(resultadoEsperado, resultado);
		
	}
	
	@Test
	public void probandoResultadoIngresandoValor360(){
		CalculadoraDePrimos calculadora = new CalculadoraDePrimos();
		ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
		
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		resultadoEsperado.add(3);
		resultadoEsperado.add(3);
		resultadoEsperado.add(5);
		
		calculadora.calcularPrimos(360);

		ArrayList<Integer> resultado  = calculadora.getListaDeNumerosPrimos("asc");
		Assert.assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void probandoCalcularEnOrdenDescendente(){
		CalculadoraDePrimos calculadora = new CalculadoraDePrimos();
		ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
		ArrayList<Integer> resultadoCalculado = new ArrayList<Integer>();
		
		resultadoEsperado.add(5);
		resultadoEsperado.add(3);
		resultadoEsperado.add(3);
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		
		calculadora.calcularPrimos(360);
		resultadoCalculado = calculadora.getListaDeNumerosPrimos("des");
		
		Assert.assertEquals(resultadoEsperado, resultadoCalculado);
	}
	
	@Test
	public void probandoCalcularEnOrdenAscendente(){
		CalculadoraDePrimos calculadora = new CalculadoraDePrimos();
		ArrayList<Integer> resultadoEsperado = new ArrayList<Integer>();
		ArrayList<Integer> resultadoCalculado = new ArrayList<Integer>();
		
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		resultadoEsperado.add(2);
		resultadoEsperado.add(3);
		resultadoEsperado.add(3);
		resultadoEsperado.add(5);
		
		calculadora.calcularPrimos(360);
		resultadoCalculado = calculadora.getListaDeNumerosPrimos("asc");
		
		Assert.assertEquals(resultadoEsperado, resultadoCalculado);
	}
	
}
