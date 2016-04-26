package ar.edu.untref.aydoo;

public class ArticuloLibreria extends Producto {
	
	public ArticuloLibreria (String nombre, double monto, int cantidad){
		super(nombre,monto);
		super.setValor((monto *cantidad) + calcularRecargo(monto, cantidad));
	}
	
	private double calcularRecargo(double monto, int cantidad){
		
		double recargo = (monto* cantidad) * 0.21;
		return recargo;
	}
}
