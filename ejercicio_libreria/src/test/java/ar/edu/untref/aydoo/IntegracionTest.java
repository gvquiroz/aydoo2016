package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {
	
	Libreria miLibreria;
	Cliente Juan;
	Cliente Maria;
	Revista Barcelona;
	Revista ElGrafico;
	Libro Hobbit;
	ArticuloDeLibreria Lapicera;
	Periodico Pagina12;
	Periodico Clarin;
	@Before
	public void initialize(){
		/*
		Revista Barcelona $20 cada ejemplar, frecuencia 15 quicenal

		Revista El Gráfico, $30 cada ejemplar, frecuencia mensual

		Libro El Hobbit $50 

		Lapicera $5 (al precio de venta hay que sumarle 21% de IVA)

		Diario Página12,  $12 cada ejemplar, frecuencia diaria

		Diario Clarín $13 cada ejemplar, frecuencia diaria
		 */
		Barcelona = new Revista(20,"quincenal");
		ElGrafico = new Revista(30, "mensual");
		Hobbit = new Libro(50);
		Lapicera = new ArticuloDeLibreria(5);
		Pagina12 = new Periodico(12,"diaria");
		Clarin = new Periodico(13,"diaria");
		
		Juan = new Cliente("Juan");
		Maria = new Cliente("Maria");
		
		miLibreria = new Libreria();
		miLibreria.addCliente(Juan);
		miLibreria.addCliente(Maria);

	}
	
	@Test
	public void calculandoMontoDeMesSinCompras(){
		miLibreria.nuevaCompra(new Compra(Juan, Lapicera, 2, "marzo"));
		
		double montoACobrar = miLibreria.CalcularMontoACrobar("diciembre", Juan);
		
		Assert.assertEquals(0, montoACobrar,0.01);
	}
	
	
	@Test
	public void calculandoMontoACobrarConUnArticuloDeLibreria(){
		miLibreria.nuevaCompra(new Compra(Juan, Lapicera, 2, "marzo"));
		
		double montoACobrar = miLibreria.CalcularMontoACrobar("marzo", Juan);
		
		Assert.assertEquals(12.1, montoACobrar,0.01);
	}
	
	@Test
	public void probandoCalcularMontoACobrarDeJuan(){
		miLibreria.nuevaCompra(new Compra(Juan, Hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(Juan, Lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(Juan, ElGrafico, 1, "agosto"));
		
		double montoACobrarEnAgosto = miLibreria.CalcularMontoACrobar("agosto", Juan);
		
		Assert.assertEquals(92.1, montoACobrarEnAgosto,0.01);
	}
	
	@Test
	public void calculandoMontoDeMariaComprandoUnEjemplar(){
		miLibreria.nuevaCompra(new Compra(Maria, Pagina12, 1, "enero"));
		
		double montoACobrar =  miLibreria.CalcularMontoACrobar("enero", Maria);
		
		Assert.assertEquals(12, montoACobrar,0.01);
	}
}
