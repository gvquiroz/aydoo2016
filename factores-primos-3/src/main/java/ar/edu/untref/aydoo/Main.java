package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static final void main(String args[]) throws IOException {

		ArrayList<Integer> resultadoDelCalculo = new ArrayList<>();
		GestorDeOpcionesDeInterfaz interfaz = new GestorDeOpcionesDeInterfaz(args);

		String resultadoFinal = "";

		int numero = 0;

		GestorDeFormatos formateador = new GestorDeFormatos();

		try {
			numero = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			System.out.println("El valor de entrada debe ser un Integer");
			System.exit(1);
		}

		CalculadoraDePrimos Calculadora = new CalculadoraDePrimos();
		Calculadora.calcularPrimos(numero);

		if (interfaz.isImprime()) {
			String nombreDelArchivo = interfaz.getNombreDeArchivo();
			resultadoDelCalculo.addAll(Calculadora.getListaDeNumerosPrimos(interfaz.getTipoDeOrdenamiento()));
			resultadoFinal = ("Factores primos " + numero + ": ");
			resultadoFinal += formateador.getDatosConFormato(resultadoDelCalculo, interfaz.getFormato());
			GestorDePersistencia escritorDeArchivos = new GestorDePersistencia(nombreDelArchivo, resultadoFinal);
		} else {
			String orden = interfaz.getTipoDeOrdenamiento();
			resultadoDelCalculo.addAll(Calculadora.getListaDeNumerosPrimos(orden));
			resultadoFinal = formateador.getDatosConFormato(resultadoDelCalculo, interfaz.getFormato());
			System.out.print("Factores primos " + numero + ": ");
			System.out.println(resultadoFinal);
		}
	}
}
