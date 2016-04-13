package ar.edu.untref.aydoo;

public class ArticuloDeLibreria extends Producto{

	public ArticuloDeLibreria(double precio) {
		super(precio);
		// TODO Auto-generated constructor stub
	}

	public double getPrecio(){
		return (super.getPrecio()*1.21);
	}
}
