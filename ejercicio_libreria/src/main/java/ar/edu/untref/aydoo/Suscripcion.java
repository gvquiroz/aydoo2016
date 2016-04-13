package ar.edu.untref.aydoo;

public class Suscripcion {
	private Cliente miCliente;
	private Producto nuevoProducto;
	private String periodicidad; 
	private String mes;
	
	public Suscripcion(Cliente nuevoCliente, Producto nuevoProducto, String periodicidad, String mes){
		this.setMiCliente(nuevoCliente);
		this.setNuevoProducto(nuevoProducto);
		this.setPeriodicidad(periodicidad);
		this.setMes(mes);
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	private void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}

	public Producto getNuevoProducto() {
		return nuevoProducto;
	}

	private void setNuevoProducto(Producto nuevoProducto) {
		this.nuevoProducto = nuevoProducto;
	}

	private void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}

	public String getMes() {
		return mes;
	}

	private void setMes(String mes) {
		this.mes = mes;
	}

	public int getCantidadDeEjemplaresPorMes() {
		int cantidadDeEjemplares = 0;
		switch (this.periodicidad){
			case "diaria":
				cantidadDeEjemplares = 30;
		}
		return cantidadDeEjemplares;
	}
}
