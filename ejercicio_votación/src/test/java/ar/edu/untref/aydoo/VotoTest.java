package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VotoTest {
	
	private Voto nuevoVoto;
	
	
    @Before 
    public void initialize() {
        nuevoVoto = new Voto(null);
        Map<String,String> PosiblesCandidatos = new HashMap<>();
        
        nuevoVoto.setCandidatoYPartido("Gabi","Partido Prueba");
     }
    
	@Test
	public void AgregandoCandidatoValido(){
        nuevoVoto.setCandidatoYPartido("Otro Candidato","Partido Prueba");
		
		Assert.assertEquals("Otro Candidato", nuevoVoto.getNombreCandidato());
	}
	
	@Test
	public void AgregandoPartidoValido(){
        nuevoVoto.setCandidatoYPartido("Gabi","Otro Partido");
		
		Assert.assertEquals("Otro Partido", nuevoVoto.getPartido());
	}
}
