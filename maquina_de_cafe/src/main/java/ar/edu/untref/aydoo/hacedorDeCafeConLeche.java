package ar.edu.untref.aydoo;

public class hacedorDeCafeConLeche {
	
	private vaso vasoRecibido;
	
	public void prepararEnEsteVaso(vaso vasito){
		this.vasoRecibido = vasito;
		this.vasoRecibido.setContenido("Cafe con leche");
	}
	
	public vaso devolverVaso(){
		return this.vasoRecibido;
	}
	
	public boolean tengoVaso(){
		return vasoRecibido != null;
	}
	
}
