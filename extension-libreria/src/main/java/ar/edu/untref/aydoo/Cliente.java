package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private ArrayList<List<ActivosKiosko>> productosComprados;
    private String nombreCliente;
    private String direccion;
    
	public Cliente(String nombre, String direccion) {

		setDireccion(direccion);
		setNombreCliente(nombre);
		
		productosComprados = new ArrayList<>(12);
		
		//Inicializo cada mes
		for (int i = 0; i < 12; i++){
			productosComprados.add(new ArrayList<>());
		}
	}
	
	public void setNombreCliente(String nombre){
		this.nombreCliente = nombre;
	}
	
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	
	public void comprar(Producto unProducto, String mes){
			productosComprados.get(getMes(mes)).add(unProducto);
	}
	
	public List<ActivosKiosko> getCompras(int nroMes){
		
		return productosComprados.get(nroMes);
	}
	
	public int getMes(String mes){
		
		int nroMes = 0;
		String mesEnMinusculas = mes.toLowerCase();
		switch(mesEnMinusculas){
			case "enero":
				nroMes = 0;
				break;
			
			case "febrero":
				nroMes = 1;
				break;
			
			case "marzo":
				nroMes = 2;
				break;
				
			case "abril":
				nroMes = 3;
				break;
			
			case "mayo":
				nroMes = 4;
				break;
			
			case "junio":
				nroMes = 5;
				break;
			
			case "julio":
				nroMes = 6;
				break;
			
			case "agosto":
				nroMes = 7;
				break;
			
			case "septiembre":
				nroMes = 8;
				break;
			
			case "octubre":
				nroMes = 9;
				break;
			
			case "noviembre":
				nroMes = 10;
				break;
			
			case "diciembre":
				nroMes = 11;
				break;
					
		}
		return nroMes;
	}

	public void alquilarEnDias(Producto miProducto, String mes, int cantidadDeDias) throws cantidadDeDiasInvalidoException {
		if(cantidadDeDias > 25 || cantidadDeDias < 3){
			throw new cantidadDeDiasInvalidoException();
		}

		Producto productoEnAlquiler = miProducto;
		productoEnAlquiler.setValor(10*cantidadDeDias);
		this.productosComprados.get(this.getMes(mes)).add(miProducto);

	}
	public void alquilarEnMeses(Alquilable miAlq){

	}
	public void alquilarEnCuatrimestres(){

	}

	public void suscribirmeA(Suscribible miSuscribible,String mes, int mesesQueMeSuscribo){
		if (mesesQueMeSuscribo > 11){
			miSuscribible.agregarDescuento();
		}
		miSuscribible.setSuscripcionMensual();
		for (int i = this.getMes(mes); i < mesesQueMeSuscribo; i++){
			productosComprados.get(i).add(miSuscribible);
		}

	}
}
