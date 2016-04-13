package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Libreria {
	
	List<Cliente> listaDeClientes = new LinkedList<>();
	List<Compra> listaDeCompras = new LinkedList<>();
	
	public void addCliente(Cliente nuevoCliente) {
		listaDeClientes.add(nuevoCliente);
	}

	public void nuevaCompra(Compra compra) {
		listaDeCompras.add(compra);
	}

	public double CalcularMontoACrobar(String mes, Cliente miCliente) {
		double montoACobrar = 0;
		Iterator<Compra> it = listaDeCompras.iterator();
		while(it.hasNext()){
			Compra compraARegistrar = it.next();
			if (compraARegistrar.getMes() == mes && compraARegistrar.getMiCliente() == miCliente){
				montoACobrar += compraARegistrar.getNuevoProducto().getPrecio() * compraARegistrar.getCantidad();
			}
		}
		return montoACobrar;
	}

}
