package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SuscripcionTest {
	Periodico Pagina12;
	Cliente Juan;
	Suscripcion nuevaSuscripcion;
	
	@Before
	public void initialize(){
		Pagina12 = new Periodico(12,"diaria");
		Juan = new Cliente("Juan");
		nuevaSuscripcion = new Suscripcion(Juan, Pagina12, Pagina12.getPeriodicidad(), "agosto");
	}
	
	@Test
	public void verCantidadDeVecesACombrarSiPeriodicidadEsDiaria(){
		int cantidadDeVeces = nuevaSuscripcion.getCantidadDeEjemplaresPorMes();
		
		Assert.assertEquals(30, cantidadDeVeces);
	}
}
