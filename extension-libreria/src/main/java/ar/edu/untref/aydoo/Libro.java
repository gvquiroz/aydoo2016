package ar.edu.untref.aydoo;

public class Libro extends Producto implements Alquilable {

	public Libro(String nombreLibro, double monto) {
		super(nombreLibro,monto);
	}

	@Override
	public void setAlquilerEnDias(int cantidadDeDias) {
		if(cantidadDeDias > 25 || cantidadDeDias < 3){
			throw new CantidadDeDiasInvalidoException();
		}
		this.setValor(cantidadDeDias*10);
	}

	@Override
	public void setAlquilerEnMeses() {

	}

	@Override
	public void setAlquilerEnCuatrimestres() {

	}
}
