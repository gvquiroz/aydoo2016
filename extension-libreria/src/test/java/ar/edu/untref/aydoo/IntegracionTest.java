package ar.edu.untref.aydoo;
import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {

	@Test
	public void testCasoClienteNoEncontrado(){
		
		Kiosko elKiosko = new Kiosko();
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);

		Cliente jose = new Cliente("José", "Av. Roca 531");
				
		Assert.assertEquals("Cliente no encontrado", 
				elKiosko.calcularMontoACobrar("Febrero",jose));
	}
	
	@Test
	public void testVentaDeUnLibroEnEnero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Libro("El Hobbit", 50);

		juan.comprar(producto1, "Enero");
				
		Assert.assertEquals("Monto a cobrarle por enero: 50.0 = $50.0", 
				elKiosko.calcularMontoACobrar("Enero",juan));
	}
	
	@Test
	public void testVentaDeUnLibroEnEneroyFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Libro("El Hobbit", 50);

		Producto producto2 = new Libro("La Metamorfosis", 70);

		juan.comprar(producto1, "Enero");
		juan.comprar(producto2, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 70.0 = $70.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void testVentaDeDosLibrosEnFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Libro("El Hobbit", 50);

		Producto producto2 = new Libro("La Metamorfosis", 70);

		juan.comprar(producto1, "Febrero");
		juan.comprar(producto2, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 50.0 + 70.0 = $120.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void testVentaDeDosLibrosYDosLapicerasEnFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Libro("El Hobbit", 50);

		Producto producto2 = new Libro("La Metamorfosis", 70);

		Producto producto3 = new ArticuloLibreria("LapiceraBic", 5, 2);

		juan.comprar(producto1, "Febrero");
		juan.comprar(producto2, "Febrero");
		juan.comprar(producto3, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 50.0 + 70.0 + 12.1 = $132.1", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void testVentaAMasDeUnClienteEnFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		Cliente pedro = new Cliente("Pedro", "Av. Libertador 4631");
		
		elKiosko.agregarCliente(juan);
		elKiosko.agregarCliente(pedro);
		
		Producto producto1 = new Libro("El Hobbit", 50);

		Producto producto2 = new Libro("La Metamorfosis", 70);

		Producto producto3 = new ArticuloLibreria("LapiceraBic", 5, 2);

		juan.comprar(producto1, "Enero");
		juan.comprar(producto2, "Febrero");
		juan.comprar(producto3, "Febrero");
		
		pedro.comprar(producto3, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 12.1 = $12.1", 
				elKiosko.calcularMontoACobrar("Febrero",pedro));
	}
	
	@Test
	public void testVentaSoloPeriodicoFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Periodico ("Clarín", 13, false);

		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 13.0 = $13.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void testSuscripcionPeriodicoFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Periodico ("Clarín", 13, true);

		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 312.0 = $312.0",
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void testSuscripcionPeriodicoFebreroVerPrecioJunio(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Periodico ("Clarín", 13, true);

		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por junio: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Junio",juan));
	}
	
	@Test
	public void testSuscripcionPeriodicoFebreroVerPrecioEnOtrosMes(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Periodico ("Clarín", 13, true);

		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por marzo: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Marzo",juan));

	}
	
	@Test
	public void testSuscripcionPeriodicoFebreroMasLibro(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Periodico ("Clarín", 13, true);

		Producto producto2 = new Libro("La Metamorfosis", 70);

		juan.comprar(producto1, "Febrero");
		juan.comprar(producto2, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 312.0 + 70.0 = $382.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void testSuscripcionRevistaMarzoVerPrecioEnOtrosMes(){
		
		Kiosko elKiosko = new Kiosko();
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		Suscribible revistaSuscribible = new Revista("Barcelona", 20, 2);

		juan.suscribirmeA(revistaSuscribible,"marzo",3);

		Assert.assertEquals("Monto a cobrarle por marzo: 40.0 = $40.0",
				elKiosko.calcularMontoACobrar("Marzo",juan));

	}
	
	@Test
	public void testCompraUnaRevistaMarzo(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Revista("Barcelona", 20, 2);

		juan.comprar(producto1, "Marzo");
		
		Assert.assertEquals("Monto a cobrarle por marzo: 20.0 = $20.0", 
				elKiosko.calcularMontoACobrar("Marzo",juan));
		
	}
	
	@Test 
	public void testClienteCompraUnLibroUnArticuloYUnPeriodico(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Libro("El Hobbit", 50);

		Producto producto2 = new ArticuloLibreria("LapiceraBic", 5, 2);

		Producto producto3 = new Periodico ("El Gráfico", 30, false);

		juan.comprar(producto1, "Agosto");
		juan.comprar(producto2, "Agosto");
		juan.comprar(producto3, "Agosto");
		
		Assert.assertEquals("Monto a cobrarle por agosto: 50.0 + 12.1 + 30.0 = $92.1", 
				elKiosko.calcularMontoACobrar("Agosto",juan));
	}
	
	@Test
	public void casoDos(){

		Kiosko elKiosko = new Kiosko();
		Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
		elKiosko.agregarCliente(maria);
		Suscribible revistaBarcelonaSuscripcion = new Revista("Barcelona", 20, 2);
		Producto producto2 = new Periodico ("Página 12", 12, false);

		maria.suscribirmeA(revistaBarcelonaSuscripcion,"Enero",12);
		maria.comprar(producto2, "Enero");
		
		Assert.assertEquals("Monto a cobrarle por enero: 32.0 + 12.0 = $44.0", 
				elKiosko.calcularMontoACobrar("Enero",maria));
	}

	@Test(expected = cantidadDeDiasInvalidoException.class)
	public  void testAlquilarUnLibroTreitaDia(){
		Kiosko unKiosko = new Kiosko();
		Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
		Producto elHobbit = new Libro("El Hobbit", 50);

		maria.alquilarEnDias(elHobbit,"Enero",30);
	}
	@Test(expected = cantidadDeDiasInvalidoException.class)
	public  void testAlquilarUnLibroUnDia(){
		Kiosko unKiosko = new Kiosko();
		Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
		Producto elHobbit = new Libro("El Hobbit", 50);

		maria.alquilarEnDias(elHobbit,"Enero",1);
	}
	@Test
	public  void testAlquilarUnLibroVeinteDias(){
		Kiosko unKiosko = new Kiosko();
		Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
		Producto elHobbit = new Libro("El Hobbit", 50);
		unKiosko.agregarCliente(maria);
		maria.alquilarEnDias(elHobbit,"Enero",20);

		Assert.assertEquals("Monto a cobrarle por enero: 200.0 = $200.0",
				unKiosko.calcularMontoACobrar("Enero",maria));
	}
	@Test
	public  void testAlquilarUnLibroDiezDias(){
		Kiosko unKiosko = new Kiosko();
		Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
		Producto elHobbit = new Libro("El Hobbit", 50);
		unKiosko.agregarCliente(maria);
		maria.alquilarEnDias(elHobbit,"Enero",10);

		Assert.assertEquals("Monto a cobrarle por enero: 100.0 = $100.0",
				unKiosko.calcularMontoACobrar("Enero",maria));
	}
}
