package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Voto {

	private Map<String,String> PosiblesCandidatos;
	private String Candidato;
	private String Partido;

	public Voto(Map<String,String> candidatosValidos) {
		this.PosiblesCandidatos = candidatosValidos;
	}

	
	
	public String getNombreCandidato() {
		return this.Candidato;
	}

	public String getPartido() {
		return this.Partido;
	}

	public void setCandidatoYPartido(String nombreDeMiCandidato,String nombreDeMiPartido) {
		this.Candidato = nombreDeMiCandidato;
		this.Partido = nombreDeMiPartido;
	}

}
