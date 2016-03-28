package ar.edu.untref.aydoo;

public class Program {
	 public static final void main(String arg[]){
	    int numero = 0;

	    /*
	    * Chequea la factibilidad de parsear el argumento a int. 
	    * En caso el usuario es avisado y termina la aplicacion
	    */
	    try {
	        numero = Integer.parseInt(arg[0]);
	    }
	    catch (NumberFormatException nfe) {
	        System.out.println("El valor de entrada debe ser un Integer");
	        System.exit(1);
	    }
	    System.out.print("Factores primos: " + numero + ": ");   

	    for(int i=2;i<=numero;i++){
	        while(numero%i==0){
	            numero=numero/i;
	            System.out.print(i+"  ");
	         
	    	}
		}
		System.out.println();
	}
}