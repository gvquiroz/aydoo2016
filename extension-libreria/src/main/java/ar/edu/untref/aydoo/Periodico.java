package ar.edu.untref.aydoo;

public class Periodico extends Producto {
	
	public Periodico (String nombrePeriodico, double monto, boolean suscripcion) {
		
		super(nombrePeriodico,monto);
		
		if (suscripcion) {
			double descuento = monto * 0.2;
			super.setValor((monto - descuento) * 30);
			super.setTipo("Periodico");
		}else {
			super.setValor(monto);
		}
	}
	
}
