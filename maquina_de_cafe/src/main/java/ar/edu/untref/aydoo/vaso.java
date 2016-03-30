package ar.edu.untref.aydoo;

public class vaso {
	
	private String contenido;
	private boolean tieneContenido;
	
	public vaso(){
		this.tieneContenido = false;
	}
	
	public void setContenido(String nuevoContenido){
		nuevoContenido = this.contenido;
	}
	
	public String getContenido(){
		return this.contenido;
	}

	public boolean isTieneContenido() {
		return tieneContenido;
	}

	public void setTieneContenido(boolean tieneContenido) {
		this.tieneContenido = tieneContenido;
	}
	
}
