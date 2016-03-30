package ar.edu.untref.aydoo;

public class azucarero {
	private vaso vasoRecibido;
	private boolean termino;
	
	public azucarero(){
		this.termino = false;
	}
	
	public void agregarAzucar(vaso enEsteVaso, int cubosDeAzucar){
		enEsteVaso.setAzucar(cubosDeAzucar);
		this.termino = true;
		this.vasoRecibido = enEsteVaso;
	}
	
	public boolean termino(){
		return this.termino;
	}
	
	public vaso devolverVasito(){
		return this.vasoRecibido;
	}
}
