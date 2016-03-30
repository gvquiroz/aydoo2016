package ar.edu.untref.aydoo;

public class hacedorDeCafeConLeche {
	
	private vaso vasoRecibido;
	private boolean termino;
	
	public hacedorDeCafeConLeche(){
		this.termino = false;
	}
	
	public void prepararEnEsteVaso(vaso vasito){
		this.vasoRecibido = vasito;
		this.vasoRecibido.setContenido("Cafe con leche");
		this.termino = true;
	}
	
	
	public boolean tengoVaso(){
		return vasoRecibido != null;
	}
	
	public boolean termino(){
		return this.termino;
	}
	
	public vaso devolverVasito(){
		return this.vasoRecibido;
	}
}
