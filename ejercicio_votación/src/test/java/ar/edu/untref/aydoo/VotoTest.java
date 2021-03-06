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
    public void votoSinCandidatoNiPartido(){
    	Assert.assertEquals("Vacio", nuevoVoto.validezDelVoto());
    }
    
	@Test
	public void agregandoCandidatoValido(){
        nuevoVoto.setCandidatoYPartido("Gabi","Partido Prueba");
		
		Assert.assertEquals("Gabi", nuevoVoto.getNombreCandidato());
	}
	
	@Test
	public void agregandoPartidoValido(){
        nuevoVoto.setCandidatoYPartido("Gabi","Partido Prueba");
		
		Assert.assertEquals("Partido Prueba", nuevoVoto.getPartido());
	}
	
	@Test
	public void chequeoValidezDeCandidatoAgregado(){
		nuevoVoto.setCandidatoYPartido("Gabi","Partido Prueba");
		Assert.assertEquals("Valido", nuevoVoto.validezDelVoto());
	}
	
	@Test
	public void chequeoVotoNuloConCandidatoNoExistente(){
		nuevoVoto.setCandidatoYPartido("Pepe","Partido Prueba");
		Assert.assertEquals("Nulo", nuevoVoto.validezDelVoto());
	}
	
	@Test
	public void chequeoVotoNuloConCandidatoEnUnPartidoNoExistente(){
		nuevoVoto.setCandidatoYPartido("Gabi","Partido Gabi");
		Assert.assertEquals("Nulo", nuevoVoto.validezDelVoto());
	}
	
	@Test
	public void chequeoVotoEnBlanco(){
		nuevoVoto.setCandidatoYPartido("","Partido Gabi");
		Assert.assertEquals("Blanco", nuevoVoto.validezDelVoto());
	}
}
