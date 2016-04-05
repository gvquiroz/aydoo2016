package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VotoTest {
	
	private Voto nuevoVoto;
	private Candidato miCandidato;
	
	
    @Before 
    public void initialize() {
        nuevoVoto = new Voto();
        miCandidato = new Candidato();
        miCandidato.setNombre("Gabi");
        miCandidato.setPartido("Partido Prueba");
     }
	
	@Test
	public void AgregandoCandidatoValido(){
		
		nuevoVoto.setCandidato(miCandidato);
		Assert.assertEquals("Gabi", nuevoVoto.getNombreCandidato());
		
	}
}
