package ar.edu.untref.aydoo;

public class Libro extends Producto {
	
	public Libro(String nombreLibro, double monto) {
		
		super(nombreLibro);
		super.setValor(monto);
		super.setTipo("Libro");
	}
}
