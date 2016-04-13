package ar.edu.untref.aydoo;

public class Periodico extends Producto {

	private String periodicidad;
	public Periodico(double precio,String asignarPeriodicidad) {
		super(precio);
		this.periodicidad = asignarPeriodicidad;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
}
