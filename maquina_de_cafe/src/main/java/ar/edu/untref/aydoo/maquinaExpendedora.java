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
	
	private vaso hacerCafeConLeche(vaso vasoDado){
		this.nuevoHacedor.prepararEnEsteVaso(vasoDado);
		return vasoDado;
	}

	private vaso ponerN(vaso vasoDado, int azucar){
		this.azucarero.agregarAzucar(vasoDado, azucar);
		return vasoDado;
	}
	
	public vaso hacerCafeConLecheConNDeAzucar(vaso vasoDelUsuario,int azucar){
		
		vasoDelUsuario = hacerCafeConLeche(vasoDelUsuario);
		vasoDelUsuario = ponerN(vasoDelUsuario, azucar);
		return vasoDelUsuario;
		
	}
}
