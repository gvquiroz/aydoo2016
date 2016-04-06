package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestorDeVotosElectorales {

	private String ganadorANivelNacional;
	private List<UrnaElectoral> UrnasElectorales = new LinkedList<>();
	
	public void addUrnaElectoral(UrnaElectoral nuevaUrna) {
		this.UrnasElectorales.add(nuevaUrna);
	}
	
	public int cantidadDeUrnasElectoralesRegistradas(){
		return this.UrnasElectorales.size();
	}

	public UrnaElectoral getUrnaElectoralEnPosicion(int posicion){
		return this.UrnasElectorales.get(posicion);
	}

	public String candidatoConMasVotosObetnidosANivelNacional() {
		
		Set<Voto> VotosRegistrados = new HashSet<>();
		Iterator<UrnaElectoral> it = UrnasElectorales.iterator();
    	Map<String,Integer> contadorDeVotosCandidatos = new HashMap<>();
		
		while (it.hasNext()){
			VotosRegistrados.addAll(it.next().getTotalidadDeVotos());
		}
		
		Iterator<Voto> itDeVotos = VotosRegistrados.iterator();
		
		while(itDeVotos.hasNext()){
			Voto votoARegistrar = itDeVotos.next();
			String nombreDelCandidato = votoARegistrar.getNombreCandidato();
			
			if(votoARegistrar.validezDelVoto() == "Valido"){
				if (contadorDeVotosCandidatos.containsKey(nombreDelCandidato)){
					
					contadorDeVotosCandidatos.put(nombreDelCandidato, contadorDeVotosCandidatos.get(nombreDelCandidato)+1);
					
				} else {
					
					contadorDeVotosCandidatos.put(nombreDelCandidato, 1);
					
				}
			}
		}
		
		
		int entry = 0;
		for (String key  : contadorDeVotosCandidatos.keySet()) {
			
			if (contadorDeVotosCandidatos.get(key)> entry){
				entry = contadorDeVotosCandidatos.get(key);
				this.ganadorANivelNacional = key;
			}
		}
		
		return this.ganadorANivelNacional;
	}
}
