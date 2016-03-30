package ar.edu.untref.aydoo;

public class vaso {
	
	private String contenido;
	private boolean tieneContenido;
	private int azucar;
	
	public vaso(){
		this.tieneContenido = false;
		this.setAzucar(0);
	}
	
	public void setContenido(String nuevoContenido){
		this.contenido = nuevoContenido;
		this.setTieneContenido(true);
	}
	
	public String getContenido(){
		return this.contenido;
	}

	public boolean isTieneContenido() {
		return tieneContenido;
	}

	private void setTieneContenido(boolean tieneContenido) {
		this.tieneContenido = tieneContenido;
	}
	public void vaciarContenido(){
		this.tieneContenido = false;
	}

	public int getAzucar() {
		return azucar;
	}

	public void setAzucar(int azucar) {
		this.azucar = azucar;
	}
	
}
