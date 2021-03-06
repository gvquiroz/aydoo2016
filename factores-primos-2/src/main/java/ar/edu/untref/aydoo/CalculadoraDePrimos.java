package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class CalculadoraDePrimos {
	
	ArrayList<Integer> listaDeNumerosPrimos = new ArrayList<Integer>();
	
	/*
	 * Calcula calculadora descomposicion de numeros primos y los guarda en un Arraylist
	 */
	public void calcularPrimos(int numero){	
	    for(int i=2;i<=numero;i++){
	        while(numero%i==0){
	            numero=numero/i;
	            listaDeNumerosPrimos.add(i);
	        }
	    }
	}
	
	/*
	 * Devuelve el array con numeros calculados en calcularPrimos
	 */
	public ArrayList<Integer> getListaDeNumerosPrimos(){
		return listaDeNumerosPrimos;
	}
}
