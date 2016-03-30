package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

public class factoresPrimos {
	 public static final void main(String args[])
	    {
		 
	        int numero = 0;
	        try {
	            numero = Integer.parseInt(args[0]);
	        }
	        catch (NumberFormatException nfe) {
	            System.out.println("El valor de entrada debe ser un Integer");
	            System.exit(1);
	        }
	        CalculadoraDePrimos Calculadora = new CalculadoraDePrimos();
	        ArrayList<Integer> resultado  = Calculadora.getListaDeNumerosPrimos();
	        System.out.println("Numero primo ingresado: " + numero);
			Iterator<Integer> it = resultado.iterator();
			
			while (it.hasNext()){
				System.out.print(" "+it.next());
			}
	    }
	 
}
