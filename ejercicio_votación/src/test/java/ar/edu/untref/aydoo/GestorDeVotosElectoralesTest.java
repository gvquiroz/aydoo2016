package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class GestorDeVotosElectoralesTest {
	
	private String Provincia;
	private UrnaElectoral nuevaUrna;
	private GestorDeVotosElectorales nuevoGestor;
	@Before 
    public void initialize() {

    	this.Provincia = "Buenos Aires"; 
        nuevaUrna = new UrnaElectoral(Provincia);
        nuevoGestor = new GestorDeVotosElectorales();
        
     }
	
	@Test
	public void agregoUrnaElectoral(){
		nuevoGestor.addUrnaElectoral(this.nuevaUrna);
		Assert.assertEquals(1, nuevoGestor.cantidadDeUrnasElectoralesRegistradas());
	}
}
