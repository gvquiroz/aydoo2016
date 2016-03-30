package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class hacedorDeCafeTest {
	private vaso nuevoVasito = new vaso();
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
}
