package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

import cucumber.api.java.ca.Cal;

public class Program {
	 public static final void main(String args[]){
		 
	        int numero = 0;
	        try {
	            numero = Integer.parseInt(args[0]);
	        }
	        catch (NumberFormatException nfe) {
	            System.out.println("El valor de entrada debe ser un Integer");
	            System.exit(1);
	        }
	        
	        CalculadoraDePrimos Calculadora = new CalculadoraDePrimos();
	        Calculadora.calcularPrimos(numero);
	        ArrayList<Integer> resultado  = Calculadora.getListaDeNumerosPrimosDeFormaAscendente();

			Iterator<Integer> it = resultado.iterator();
			/*
			 * Flag de control y seteo de default en el caso de que el formato no este especificado
			 */
			String formatoDeDevolucion = null;
			
			if (args.length == 1){
				formatoDeDevolucion = "--format=pretty";
			} else {
				formatoDeDevolucion = args[1];
			}

	        switch (formatoDeDevolucion.toLowerCase()) {
	         	case "--format=pretty":
	 		    System.out.print("Factores primos: " + numero + ": ");
	 			while (it.hasNext()){
	 				System.out.print(it.next() + " ");
				}
	             break;
	         case "--format=quiet":
	 		     System.out.print("Factores primos: " + numero + ": ");
	        	 System.out.println();
	        	 while (it.hasNext()){
		 				System.out.println(it.next() + " ");
	        	 }
	        	 break;
	         default:
	        	 System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
	     }
			System.out.println();
	    }
}