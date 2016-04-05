package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UrnaElectoralTest {
	
    private UrnaElectoral nuevaUrna;
	private Voto nuevoVoto;

	@Before 
    public void initialize() {
    	Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Gabi","Partido Prueba");
    	
        nuevaUrna = new UrnaElectoral();
        nuevoVoto = new Voto(PosiblesCandidatos);
     }
    
    @Test
    public void SumoUnNuevoVoto(){
    	nuevaUrna.addVoto(nuevoVoto);
    	Assert.assertEquals(1, nuevaUrna.cantidadDeVotos());
    }
    
}
