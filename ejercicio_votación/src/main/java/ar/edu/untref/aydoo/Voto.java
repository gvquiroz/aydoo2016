package ar.edu.untref.aydoo;


import java.util.Map;

public class Voto {

	private Map<String,String> PosiblesCandidatos;
	private String Candidato;
	private String Partido;
	private String EstadoDelVoto;

	public Voto(Map<String,String> candidatosValidos) {
		this.PosiblesCandidatos = candidatosValidos;
		this.EstadoDelVoto = "Vacio";
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
		
		if (PosiblesCandidatos.containsKey(nombreDeMiCandidato) &&
			PosiblesCandidatos.containsValue(nombreDeMiPartido)){
			this.EstadoDelVoto = "Valido";
		} else {
			this.EstadoDelVoto = "Nulo";
		}
		
	}
	
	public String validezDelVoto(){
		return this.EstadoDelVoto;
	}
	
}
