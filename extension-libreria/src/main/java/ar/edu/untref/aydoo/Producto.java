package ar.edu.untref.aydoo;

public class Producto {
	
	private double valor;
	private String tipo;
	
	public Producto (String nombre){
		
		setNombreProducto(nombre);
	}
	
	public void setValor(double valor){
		
		this.valor = valor;
	}
	
	public void setNombreProducto(String nombre){
	}
	
	public void setTipo(String tipoProducto){
		this.tipo = tipoProducto;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public double getValor(){
		
		return this.valor;
	}
}
