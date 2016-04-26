package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;


public class Kiosko {
	
    private List<Cliente> clientes;
	
	public Kiosko(){
		this.clientes = new ArrayList<>();
	}
	
	public void agregarCliente(Cliente unCliente) {
		clientes.add(unCliente);
	}

	public String calcularMontoACobrar(String mes, Cliente cliente) {
		
		Cliente clientePedido = null;
		List <ActivosKiosko> compras;
		List <Double> valores = new ArrayList<>();
		double montoTotal = 0;
		boolean encontrado = false;
		
		//Verifica si existe el cliente
		for (int i = 0; i < clientes.size(); i++){
			
			if (cliente == clientes.get(i)){
				clientePedido = clientes.get(i);
				encontrado = true;
			}
		}
		
		if (encontrado){
			compras = clientePedido.getCompras(clientePedido.getMes(mes));
			for(int i = 0; i < compras.size(); i++){
				valores.add(compras.get(i).getValor());
				montoTotal += compras.get(i).getValor();		
			}
		}
		return mensaje (valores, montoTotal, mes, encontrado);
	}
	
	private String mensaje(List <Double> valores, double montoTotal, 
							String mes, boolean encontrado){
		
		String mensaje;
		String precios = "";
		
		if (encontrado){
			for( int i = 0; i < valores.size(); i ++){
				if (i == valores.size()-1){
					precios += " " + valores.get(i); 
				}else{
					precios += " " + valores.get(i) + " " + "+";
				
				}
			}
			
			mensaje = "Monto a cobrarle por " + mes.toLowerCase() + ":" + precios + " = $" + montoTotal;
		}
		else{
			mensaje = "Cliente no encontrado";
		}
		
		return mensaje;
	}
}
