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
    	Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Gabi","Partido Prueba");
    	
        nuevoVoto = new Voto(PosiblesCandidatos);
     }
    
    @Test
    public void VotoSinCandidatoNiPartido(){
    	Assert.assertEquals("Vacio", nuevoVoto.validezDelVoto());
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
