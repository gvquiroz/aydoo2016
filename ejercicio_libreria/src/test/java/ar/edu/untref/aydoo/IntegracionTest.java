package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {
	
	Libreria miLibreria;
	Cliente Juan;
	Cliente Maria;
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
		Revista Barcelona = new Revista(20,"quincenal");
		Revista ElGrafico = new Revista(30, "mensual");
		Libro Hobbit = new Libro(50);
		ArticuloDeLibreria Lapicera = new ArticuloDeLibreria(5);
		Periodico Pagina12 = new Periodico(12,"diaria");
		Periodico Clarin = new Periodico(13,"diaria");
		
		Juan = new Cliente("Juan");
		Maria = new Cliente("Maria");
		
		miLibreria = new Libreria();
		miLibreria.addCliente(Juan);
		miLibreria.addCliente(Maria);
		miLibreria.nuevaCompra(new Compra(Juan, Hobbit, 1, "agosto"));
		miLibreria.nuevaCompra(new Compra(Juan, Lapicera, 2, "agosto"));
		miLibreria.nuevaCompra(new Compra(Juan, ElGrafico, 1, "agosto"));
	}
	
	@Test
	public void probandoCalcularMontoACobrarDeJuan(){
		double montoACobrarEnAgosto = miLibreria.CalcularMontoACrobar("agosto", Juan);
		Assert.assertEquals(92.1, montoACobrarEnAgosto,0.01);
	}
}
