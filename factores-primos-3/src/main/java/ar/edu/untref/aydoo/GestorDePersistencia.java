package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class GestorDePersistencia {

	private String nombreDelArchivo;
	private String datosAGuardar;

	public GestorDePersistencia(String nuevoNombreDeArchivo, String datos) throws IOException {
		this.nombreDelArchivo = nuevoNombreDeArchivo;
		this.datosAGuardar = datos;
		this.crearArchivo();
	}

	private void crearArchivo() throws IOException {
		File archivo = new File(this.nombreDelArchivo);
		archivo.createNewFile();
		PrintStream escritor = new PrintStream(archivo);
		escritor.print(datosAGuardar);
		escritor.close();
	}
	
}
