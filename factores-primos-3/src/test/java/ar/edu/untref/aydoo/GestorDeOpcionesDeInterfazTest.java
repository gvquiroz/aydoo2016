package ar.edu.untref.aydoo;

import org.junit.Test;

import junit.framework.Assert;

public class GestorDeOpcionesDeInterfazTest {
	@Test
	public void agregandoParametroPretty(){
		String args[] = {"--format=quiett"};
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);
		String formatoEsperado = "quiett";
		
		String resultado = interfaz.getFormato();
		
		Assert.assertEquals(formatoEsperado, resultado);
	}
	@Test
	public void agregandoDosParametrosChequeoSort(){
		String args[] = {"--format=quiett","--sort:des"};
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);
		String ordenEsperado = "des";
		
		String resultado = interfaz.getTipoDeOrdenamiento();
		
		Assert.assertEquals(ordenEsperado, resultado);
	}
	@Test
	public void chequeoQueSinAgregarParametroOutputNoExisteFile(){
		String args[] = {"--format=quiett","--sort:des"};
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);
		String archivoEsperado = null;
		
		String resultado = interfaz.getNombreDeArchivo();
		
		Assert.assertEquals(archivoEsperado, resultado);
	}
	@Test
	public void agregandoDosParametrosChequeoSortYLesCambioElOrden(){
		String args[] = {"--sort:des","--format=quiett"};
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);
		String ordenEsperado = "des";
		
		String resultado = interfaz.getTipoDeOrdenamiento();
		
		Assert.assertEquals(ordenEsperado, resultado);
	}
	@Test
	public void agregandoDosParametrosYPreguntoSiImprime(){
		String args[] = {"--sort:des","--format=quiett"};
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);
		boolean imrpime = false;
		
		boolean resultado = interfaz.isImprime();
		
		Assert.assertEquals(imrpime, resultado);
	}
	@Test
	public void agregandoParametrosYOutputFileYPreguntoSiImprime(){
		String args[] = {"--format=quiett", "--sort:des", "--output-file=salida.txt"};
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);
		boolean imrpime = true;
		
		boolean resultado = interfaz.isImprime();
		
		Assert.assertEquals(imrpime, resultado);
	}
	@Test
	public void agregandoParametrosYOutputFileYNombreDeArchivo(){
		String args[] = {"--format=quiett", "--sort:des", "--output-file=salida.txt"};
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);
		String formatoEsperado = "salida.txt";
		
		String resultado = interfaz.getNombreDeArchivo();
		
		Assert.assertEquals(formatoEsperado, resultado);
	}
}
