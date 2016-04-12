package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto{

	public double getPrecio(){
		return (super.getPrecio()*1.21);
	}
}
