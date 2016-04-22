package ar.edu.untref.aydoo;

public class Periodico extends Producto {
	
	public Periodico (String nombrePeriodico, double monto, 
			boolean ejemplarSuelto, boolean suscripcion) {
		
		super(nombrePeriodico);
		
		if (ejemplarSuelto == true || suscripcion == true){
			
			if (ejemplarSuelto == true){
		
				super.setValor(monto);
			}
			else if(suscripcion == true){
				double descuento = monto*0.2;
				super.setValor((monto - descuento)*30);
				super.setTipo("Periodico");	
			}
		}
		
	}
	
}
