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
	public void setAlquilerEnMeses(int cantidadDeMeses) {
		if(cantidadDeMeses > 3 || cantidadDeMeses < 1){
			throw new CantidadDeMesesInvalidoException();
		}
		this.setValor(cantidadDeMeses*200);
	}

	@Override
	public void setAlquilerEnCuatrimestres(int cantidadDeCuatrimestres) {
		double descuento = (200*cantidadDeCuatrimestres*4)*(0.1 * cantidadDeCuatrimestres);
		this.setValor(200*cantidadDeCuatrimestres*4-descuento);

	}
}
