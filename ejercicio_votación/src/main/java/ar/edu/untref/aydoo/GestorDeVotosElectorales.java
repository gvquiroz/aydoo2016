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
	private String partidoGanadorEnProvincia;
	
	public void addUrnaElectoral(UrnaElectoral nuevaUrna) {
		this.UrnasElectorales.add(nuevaUrna);
	}
	
	public int cantidadDeUrnasElectoralesRegistradas(){
		return this.UrnasElectorales.size();
	}

	public int cantidadDeVotosRegistrados(){
		
		Set<Voto> VotosRegistrados = new HashSet<>();
		Iterator<UrnaElectoral> it = UrnasElectorales.iterator();
		
		while (it.hasNext()){
			VotosRegistrados.addAll(it.next().getTotalidadDeVotos());
		}
		
		return VotosRegistrados.size();
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
	
	
	
	public String PartidoEnProvincia(String provincia){
		
		Set<Voto> VotosRegistrados = new HashSet<>();
    	Map<String,Integer> contadorDeVotosPartidosDeCiertaProvincia = new HashMap<>();
    	
		Iterator<UrnaElectoral> it = UrnasElectorales.iterator();
		while (it.hasNext()){
			UrnaElectoral UrnaARegistrar = it.next();
			
			if (UrnaARegistrar.enQuePronviciaEstaLaUrna() == provincia){
				VotosRegistrados.addAll(UrnaARegistrar.getTotalidadDeVotos());
				
			}
		}
		
		Iterator<Voto> itDeVotos = VotosRegistrados.iterator();
		
		while(itDeVotos.hasNext()){
			Voto votoARegistrar = itDeVotos.next();
			String nombreDelPartido = votoARegistrar.getPartido();
			
			if(votoARegistrar.validezDelVoto() == "Valido"){
				if (contadorDeVotosPartidosDeCiertaProvincia.containsKey(nombreDelPartido)){
					contadorDeVotosPartidosDeCiertaProvincia.put(nombreDelPartido, contadorDeVotosPartidosDeCiertaProvincia.get(nombreDelPartido)+1);
				} else {
					contadorDeVotosPartidosDeCiertaProvincia.put(nombreDelPartido, 1);
				}
			}
		}
		
		int entry = 0;
		for (String key  : contadorDeVotosPartidosDeCiertaProvincia.keySet()) {
			
			if (contadorDeVotosPartidosDeCiertaProvincia.get(key)> entry){
				entry = contadorDeVotosPartidosDeCiertaProvincia.get(key);
				this.partidoGanadorEnProvincia = key;
			}
		}
		
		return partidoGanadorEnProvincia;
		
	}
}
