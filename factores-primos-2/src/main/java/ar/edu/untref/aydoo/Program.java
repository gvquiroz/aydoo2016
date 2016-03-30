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
	        System.out.print("Factores primos: " + numero + ": ");
			Iterator<Integer> it = resultado.iterator();
			
			while (it.hasNext()){
				System.out.print(it.next() + " ");
			}
			System.out.println();
	    }
}