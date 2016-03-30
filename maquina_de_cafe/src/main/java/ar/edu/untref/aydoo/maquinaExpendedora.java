package ar.edu.untref.aydoo;

public class maquinaExpendedora {
	
	private hacedorDeCafeConLeche nuevoHacedor;
	private azucarero azucarero;
	public maquinaExpendedora() {
		this.setHacedorDeBebida(new hacedorDeCafeConLeche());
		this.setAzucarero(new azucarero());
	}

	private void setAzucarero(azucarero azucarero) {
		this.azucarero = azucarero;
	}
	
	
	private void setHacedorDeBebida(hacedorDeCafeConLeche hacedorDeBebida) {
		this.nuevoHacedor = hacedorDeBebida;
	}
	
	public vaso hacerCafeConLecheConNDeAzucar(vaso vasoDado, int cantidadDeAzucar){
		this.nuevoHacedor.prepararEnEsteVaso(vasoDado);
		
		return vasoDado;
	}
	
}
