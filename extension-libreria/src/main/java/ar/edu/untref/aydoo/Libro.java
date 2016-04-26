package ar.edu.untref.aydoo;

public class Libro extends Producto {

	public Libro(String nombreLibro, double monto) {
		
		super(nombreLibro,monto);
		super.setTipo("Libro");
	}

}
