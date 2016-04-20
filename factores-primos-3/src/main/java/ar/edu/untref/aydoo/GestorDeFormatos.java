package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorDeFormatos {

	public String getDatosConFormato(ArrayList<Integer> nuevosValores, String formato) {
		String resultado = "";
		Iterator<Integer> it = nuevosValores.iterator();
		
		switch(formato.toLowerCase()){
			case "pretty":
				while(it.hasNext()){
					resultado += it.next()+" ";
				}
				break;
			
			case "quiett":
				while(it.hasNext()){
					resultado +="\r\n"+it.next();
				}
				break;
		}
		return resultado;
	}
}
