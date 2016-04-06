package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class UrnaElectoral {

	
	List<Voto> Votos = new LinkedList<>();
	private String provinciaEnDondeEstaLaUrna ;
	
	public UrnaElectoral(String provincia) {
		
		this.provinciaEnDondeEstaLaUrna = provincia;
		
	}

	public void addVoto(Voto nuevoVoto) {
		this.Votos.add(nuevoVoto);
	}

	public int cantidadDeVotos(){
		return Votos.size();
	}
	
	public String enQuePronviciaEstaLaUrna(){
		return this.provinciaEnDondeEstaLaUrna;
	}
	
}
