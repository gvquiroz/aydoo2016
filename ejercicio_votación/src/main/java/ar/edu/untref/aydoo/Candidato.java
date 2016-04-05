package ar.edu.untref.aydoo;

public class Candidato {
	private String Nombre;
	private String Partido;
	
	public void setNombre(String nombreDelCandidato) {
		this.Nombre = nombreDelCandidato;
	}

	public void setPartido(String miPartido) {
		this.Partido = miPartido;
		
	}

	public String getNombre() {
		return this.Nombre;
	} 
}
