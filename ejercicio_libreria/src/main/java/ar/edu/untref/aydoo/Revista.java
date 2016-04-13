package ar.edu.untref.aydoo;

public class Revista extends Producto{

	private String periodicidad;
	public Revista(double precio, String asignarPeriodicidad) {
		super(precio);
		this.periodicidad = asignarPeriodicidad;
	}
	public String getPeriodicidad() {
		return periodicidad;
	}
}
