package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class maquinaExpendedoraTest {
	private vaso nuevoVasito = new vaso();
	private hacedorDeCafeConLeche hacedor = new hacedorDeCafeConLeche();
	private maquinaExpendedora maquina = new maquinaExpendedora();
	private azucarero azucareroTest = new azucarero();
	
	@Test
	public void probandovasoSinContenido(){
		Assert.assertEquals(false, nuevoVasito.isTieneContenido());
	}
	
	@Test
	public void probandoIngresarContenidoEnVaso(){
		nuevoVasito.setContenido("cafe");
		
		Assert.assertEquals("cafe",nuevoVasito.getContenido());
	}
	@Test
	public void probandoIngresarContenidoyChequeoDeContenido(){
		nuevoVasito.setContenido("cafe");
		
		Assert.assertEquals("cafe",nuevoVasito.getContenido());
		Assert.assertEquals(true, nuevoVasito.isTieneContenido());
	}
	@Test
	public void probandoIngresaryVaciarContenido(){
		nuevoVasito.setContenido("cafe");
		
		Assert.assertEquals("cafe",nuevoVasito.getContenido());
		nuevoVasito.vaciarContenido();
		Assert.assertEquals(false, nuevoVasito.isTieneContenido());
	}
	@Test
	public void probandoAgregarAzucar(){
		nuevoVasito.setContenido("cafe");
		
		Assert.assertEquals("cafe",nuevoVasito.getContenido());
		nuevoVasito.setAzucar(2);
		Assert.assertEquals(2, nuevoVasito.getAzucar());
	}
	@Test
	public void probandoAzucarero(){
		azucareroTest.agregarAzucar(nuevoVasito, 2);
		
		Assert.assertEquals(2, nuevoVasito.getAzucar());
	}
	
	@Test
	public void probandoAzucareroDevolverVasito(){
		azucareroTest.agregarAzucar(nuevoVasito, 2);
		
		Assert.assertEquals(2, this.azucareroTest.devolverVasito().getAzucar());
	}
	@Test
	public void probandoAgregarAzucarYVaciarContenido(){
		nuevoVasito.setContenido("cafe");
		
		Assert.assertEquals("cafe",nuevoVasito.getContenido());
		nuevoVasito.setAzucar(2);
		Assert.assertEquals(2, nuevoVasito.getAzucar());
		nuevoVasito.vaciarContenido();
		Assert.assertEquals(false, nuevoVasito.isTieneContenido());
		Assert.assertEquals(0, nuevoVasito.getAzucar());
	}
	
	@Test
	public void probandoHacedorTengoVaso(){
		Assert.assertEquals(false, hacedor.tengoVaso());
		hacedor.prepararEnEsteVaso(nuevoVasito);
		Assert.assertEquals(true, hacedor.tengoVaso());
	}
	
	@Test
	public void probandoHacedorPrepararEnEsteVaso(){
		hacedor.prepararEnEsteVaso(nuevoVasito);
		Assert.assertEquals("Cafe con leche", nuevoVasito.getContenido());
	}
	@Test
	public void probandoHacedorTermino(){
		Assert.assertEquals(false, hacedor.termino());
		hacedor.prepararEnEsteVaso(nuevoVasito);
		Assert.assertEquals(true, hacedor.termino());
	}
	
	@Test
	public void probandoHacerCafeConMaquinaExpendedora(){
		maquina.hacerCafeConLecheConNDeAzucar(nuevoVasito,0);
		Assert.assertEquals("Cafe con leche", nuevoVasito.getContenido());
	}
	
	@Test
	public void probandoHacerCafeConMaquinaExpendedoraYAgregarleAzucar(){
		maquina.hacerCafeConLecheConNDeAzucar(nuevoVasito,5);
		Assert.assertEquals(5, nuevoVasito.getAzucar());
	}
	
}
