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
}
