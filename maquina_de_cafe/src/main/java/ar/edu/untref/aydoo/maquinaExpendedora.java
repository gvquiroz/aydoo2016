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
	
	private void hacerCafeConLeche(vaso vasoDado){
		this.nuevoHacedor.prepararEnEsteVaso(vasoDado);
	}

	private void ponerN(vaso vasoDado, int azucar){
		this.azucarero.agregarAzucar(vasoDado, azucar);
	}
	
	public vaso hacerCafeConLecheConNDeAzucar(vaso vasoDelUsuario,int azucar){
		
		hacerCafeConLeche(vasoDelUsuario);
		if (this.nuevoHacedor.termino()){
			vasoDelUsuario = this.nuevoHacedor.devolverVasito();
		}
		ponerN(vasoDelUsuario, azucar);
		if (this.azucarero.termino()){
			vasoDelUsuario = this.azucarero.devolverVasito();
		}
		
		return vasoDelUsuario;
		
	}
}
