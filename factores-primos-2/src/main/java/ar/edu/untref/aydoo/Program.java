package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

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
	        ArrayList<Integer> resultado  = Calculadora.getListaDeNumerosPrimos();

			Iterator<Integer> it = resultado.iterator();
			
			/*
			 * Switch que reconoce el tipo de formato para la entrega de valores
			 */
			String formatoDeDevolucion = args[1];
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
	        	 
	        	 /*
	        	  * Utilizado un for inverso para cambiar el orden de entrega de valores segun consigna
	        	  */
	        	 
	        	 for(int j = resultado.size() - 1; j >= 0; j--){
	        		 System.out.println(resultado.get(j));
	        	}
	        	 break;
	         default:
	        	 System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
	     }

			System.out.println();
	    }
}