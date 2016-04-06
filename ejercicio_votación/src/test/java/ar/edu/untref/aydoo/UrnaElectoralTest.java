package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UrnaElectoralTest {
	
    private UrnaElectoral nuevaUrna;
	private Voto nuevoVoto;
	private String Provincia;

	@Before 
    public void initialize() {
    	Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Gabi","Partido Prueba");
    	this.Provincia = "Buenos Aires";
        
        nuevaUrna = new UrnaElectoral(Provincia);
        nuevoVoto = new Voto(PosiblesCandidatos);
     }
    
    @Test
    public void sumoUnNuevoVoto(){
    	nuevaUrna.addVoto(nuevoVoto);
    	Assert.assertEquals(1, nuevaUrna.cantidadDeVotos());
    }
    
    @Test
    public void sumoDosVotos(){
    	Map<String,String> PosiblesCandidatos = new HashMap<>();
    	Voto PrimerVoto = new Voto(PosiblesCandidatos);
    	Voto SegundoVoto = new Voto(PosiblesCandidatos);
    	
    	nuevaUrna.addVoto(PrimerVoto);
    	nuevaUrna.addVoto(SegundoVoto);
    	
    	Assert.assertEquals(2, nuevaUrna.cantidadDeVotos());
    }
    
    @Test
    public void chequeoDePronviciaDeLaUrna(){
    	Assert.assertEquals("Buenos Aires", nuevaUrna.enQuePronviciaEstaLaUrna());
    }
    
}
