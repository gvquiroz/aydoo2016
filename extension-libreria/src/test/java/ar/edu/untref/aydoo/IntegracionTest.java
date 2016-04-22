package ar.edu.untref.aydoo;
import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {

	@Test
	public void casoClienteNoEncontrado(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Clarín");
		producto1 = new Periodico ("Clarín", 13, false, true);
		
		juan.comprar(producto1, "Febrero");
		
		Cliente jose = new Cliente("José", "Av. Roca 531");
				
		Assert.assertEquals("Cliente no encontrado", 
				elKiosko.calcularMontoACobrar("Febrero",jose));
	}
	
	@Test
	public void casoVentaDeUnLibroEnEnero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("El Hobbit");
		producto1 = new Libro("El Hobbit", 50);
		
		juan.comprar(producto1, "Enero");
				
		Assert.assertEquals("Monto a cobrarle por enero: 50.0 = $50.0", 
				elKiosko.calcularMontoACobrar("Enero",juan));
	}
	
	@Test
	public void casoVentaDeUnLibroEnEneroyFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("El Hobbit");
		producto1 = new Libro("El Hobbit", 50);
		
		Producto producto2 = new Producto("La Metamorfosis");
		producto2 = new Libro("La Metamorfosis", 70);
		
		juan.comprar(producto1, "Enero");
		juan.comprar(producto2, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 70.0 = $70.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void casoVentaDeDosLibrosEnFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("El Hobbit");
		producto1 = new Libro("El Hobbit", 50);
		
		Producto producto2 = new Producto("La Metamorfosis");
		producto2 = new Libro("La Metamorfosis", 70);
		
		juan.comprar(producto1, "Febrero");
		juan.comprar(producto2, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 50.0 + 70.0 = $120.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void casoVentaDeDosLibrosYDosLapicerasEnFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("El Hobbit");
		producto1 = new Libro("El Hobbit", 50);
		
		Producto producto2 = new Producto("La Metamorfosis");
		producto2 = new Libro("La Metamorfosis", 70);
		
		Producto producto3 = new Producto("LapiceraBic");
		producto3 = new ArticuloLibreria("LapiceraBic", 5, 2);
		
		juan.comprar(producto1, "Febrero");
		juan.comprar(producto2, "Febrero");
		juan.comprar(producto3, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 50.0 + 70.0 + 12.1 = $132.1", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void casoVentaAMasDeUnClienteEnFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		Cliente pedro = new Cliente("Pedro", "Av. Libertador 4631");
		
		elKiosko.agregarCliente(juan);
		elKiosko.agregarCliente(pedro);
		
		Producto producto1 = new Producto("El Hobbit");
		producto1 = new Libro("El Hobbit", 50);
		
		Producto producto2 = new Producto("La Metamorfosis");
		producto2 = new Libro("La Metamorfosis", 70);
		
		Producto producto3 = new Producto("LapiceraBic");
		producto3 = new ArticuloLibreria("LapiceraBic", 5, 2);
		
		juan.comprar(producto1, "Enero");
		juan.comprar(producto2, "Febrero");
		juan.comprar(producto3, "Febrero");
		
		pedro.comprar(producto3, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 12.1 = $12.1", 
				elKiosko.calcularMontoACobrar("Febrero",pedro));
	}
	
	@Test
	public void casoVentaSoloPeriodicoFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Clarín");
		producto1 = new Periodico ("Clarín", 13, true, false);
		
		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 13.0 = $13.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void casoSuscripcionPeriodicoFebrero(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Clarín");
		producto1 = new Periodico ("Clarín", 13, false, true);
		
		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void casoSuscripcionPeriodicoFebreroVerPrecioJunio(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Clarín");
		producto1 = new Periodico ("Clarín", 13, false, true);
		
		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por junio: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Junio",juan));
	}
	
	@Test
	public void casoSuscripcionPeriodicoFebreroVerPrecioEnOtrosMes(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Clarín");
		producto1 = new Periodico ("Clarín", 13, false, true);
		
		juan.comprar(producto1, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por marzo: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Marzo",juan));
		
		Assert.assertEquals("Monto a cobrarle por abril: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Abril",juan));
		
		Assert.assertEquals("Monto a cobrarle por mayo: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Mayo",juan));
		
		Assert.assertEquals("Monto a cobrarle por julio: 312.0 = $312.0", 
				elKiosko.calcularMontoACobrar("Julio",juan));
	}
	
	@Test
	public void casoSuscripcionPeriodicoFebreroMasLibro(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Clarín");
		producto1 = new Periodico ("Clarín", 13, false, true);
		
		Producto producto2 = new Producto("La Metamorfosis");
		producto2 = new Libro("La Metamorfosis", 70);
		
		juan.comprar(producto1, "Febrero");
		juan.comprar(producto2, "Febrero");
		
		Assert.assertEquals("Monto a cobrarle por febrero: 312.0 + 70.0 = $382.0", 
				elKiosko.calcularMontoACobrar("Febrero",juan));
	}
	
	@Test
	public void casoSuscripcionRevistaMarzoVerPrecioEnOtrosMes(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Barcelona");
		producto1 = new Revista("Barcelona", 20, 2);
		
		juan.comprar(producto1, "Marzo");
		
		Assert.assertEquals("Monto a cobrarle por septiembre: 32.0 = $32.0", 
				elKiosko.calcularMontoACobrar("Septiembre",juan));
		
		Assert.assertEquals("Monto a cobrarle por octubre: 32.0 = $32.0", 
				elKiosko.calcularMontoACobrar("Octubre",juan));
		
		Assert.assertEquals("Monto a cobrarle por noviembre: 32.0 = $32.0", 
				elKiosko.calcularMontoACobrar("Noviembre",juan));
		
		Assert.assertEquals("Monto a cobrarle por diciembre: 32.0 = $32.0", 
				elKiosko.calcularMontoACobrar("Diciembre",juan));
	}
	
	@Test
	public void casoCompraUnaRevistaMarzo(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("Barcelona");
		producto1 = new Revista("Barcelona", 20, 0);
		
		juan.comprar(producto1, "Marzo");
		
		Assert.assertEquals("Monto a cobrarle por marzo: 20.0 = $20.0", 
				elKiosko.calcularMontoACobrar("Marzo",juan));
		
	}
	
	@Test 
	public void casoUno(){
		
		Kiosko elKiosko = new Kiosko();
		
		Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
		elKiosko.agregarCliente(juan);
		
		Producto producto1 = new Producto("El Hobbit");
		producto1 = new Libro("El Hobbit", 50);
		
		Producto producto2 = new Producto("LapiceraBic");
		producto2 = new ArticuloLibreria("LapiceraBic", 5, 2);
		
		Producto producto3 = new Producto("El Gráfico");
		producto3 = new Periodico ("El Gráfico", 30, true, false);
				
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
		
		Producto producto1 = new Producto("Barcelona");
		producto1 = new Revista("Barcelona", 20, 2);
		
		Producto producto2 = new Producto("Página 12");
		producto2 = new Periodico ("Página 12", 12, true, false);
				
		maria.comprar(producto1, "Enero");
		maria.comprar(producto2, "Enero");
		
		Assert.assertEquals("Monto a cobrarle por enero: 32.0 + 12.0 = $44.0", 
				elKiosko.calcularMontoACobrar("Enero",maria));
	}
}
