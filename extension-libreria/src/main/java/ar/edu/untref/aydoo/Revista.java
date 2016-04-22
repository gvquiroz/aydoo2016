package ar.edu.untref.aydoo;

public class Revista extends Producto {
	
	//frecuenciaMensual indica cuantas veces al mes sale la revista
	public Revista(String nombreRevista, double monto, 
				 int frecuenciaMensual) {
		super(nombreRevista);

		if (frecuenciaMensual == 0){
			
			super.setValor(monto);
			
		}else if (frecuenciaMensual > 0 && frecuenciaMensual < 5){
			
			super.setTipo("Revista");
			double descuento = monto*0.2;
			super.setValor((monto - descuento)*frecuenciaMensual);
			
		}
	}
}
