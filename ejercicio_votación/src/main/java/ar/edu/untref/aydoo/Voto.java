package ar.edu.untref.aydoo;

public class Voto {

	private Candidato miCandidato;
	
	public void setCandidato(Candidato nuevoCandidato) {
		this.miCandidato = nuevoCandidato;
	}

	public String getNombreCandidato() {
		
		return this.miCandidato.getNombre();
	}

}
