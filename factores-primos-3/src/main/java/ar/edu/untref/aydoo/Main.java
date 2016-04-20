package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Main {
	public static final void main(String args[]) {
		String ordenDefault = "asc";
		String formatoDefault = "pretty";
		ArrayList<Integer> resultadoDelCalculo = new ArrayList<>();
		String resultado = "";
		
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
        
        
        if (args.length == 1){
			resultadoDelCalculo.addAll(Calculadora.getListaDeNumerosPrimos(ordenDefault));
			resultado = formateador.getDatosConFormato(resultadoDelCalculo, formatoDefault);
			System.out.print("Factores primos " + numero + ": ");
			System.out.println(resultado);
        }
        
        
        
	}
}
