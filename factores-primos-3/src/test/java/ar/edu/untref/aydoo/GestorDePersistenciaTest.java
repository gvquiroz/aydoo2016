package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GestorDePersistenciaTest {

	@Test
	public void ProbandoCreacionDeArchivo() throws IOException{
		String nombreDelArchivo = "test.txt"; 
		File Entrada = new File(nombreDelArchivo);
		GestorDePersistencia miGestor = new GestorDePersistencia(nombreDelArchivo,"");

		Assert.assertEquals(true, Entrada.exists()); 
		
		Entrada.delete();
	}
	@Test
	public void ProbandoGuardarDatosEnArchivo() throws IOException{
		String nombreDelArchivo = "test.txt"; 
		String datosDePrueba = "Un dato";
		GestorDePersistencia miGestor = new GestorDePersistencia(nombreDelArchivo,datosDePrueba);
		
		File Entrada = new File(nombreDelArchivo);
		FileReader lector = new FileReader(Entrada);
		BufferedReader lectorDeLineas = new BufferedReader(lector);
		
		Assert.assertEquals(lectorDeLineas.readLine(), datosDePrueba); 
		
		lectorDeLineas.close();
		lector.close();
		Entrada.delete();
	}
}
