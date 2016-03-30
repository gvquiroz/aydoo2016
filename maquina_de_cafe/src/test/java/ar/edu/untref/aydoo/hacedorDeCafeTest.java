package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class hacedorDeCafeTest {
	
	@Test
	public void probandoIngresarContenidoEnVaso(){
		vaso nuevoVasito = new vaso();
		Assert.assertEquals(false, nuevoVasito.isTieneContenido());
	}
}
