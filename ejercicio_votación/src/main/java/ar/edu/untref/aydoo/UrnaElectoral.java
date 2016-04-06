package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class UrnaElectoral {

	
	List<Voto> Votos = new LinkedList<>();
	
	public void addVoto(Voto nuevoVoto) {
		this.Votos.add(nuevoVoto);
	}

	public int cantidadDeVotos(){
		return Votos.size();
	}
	
}
