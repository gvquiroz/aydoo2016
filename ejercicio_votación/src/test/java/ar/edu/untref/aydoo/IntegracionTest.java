package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegracionTest {

    private UrnaElectoral nuevaUrna;
	private Voto nuevoVoto;
	private GestorDeVotosElectorales gestorPrincipal;
	private String provincia;

	@Before 
    public void initialize() {
		
    	Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Gabi","Partido Prueba");
    	provincia = "Buenos Aires";
        
        nuevaUrna = new UrnaElectoral(provincia);
        nuevoVoto = new Voto(PosiblesCandidatos);
        gestorPrincipal = new GestorDeVotosElectorales();
        
     }
	
	@Test
	public void emisionDelVoto(){
		
		nuevoVoto.setCandidatoYPartido("Gabi","Partido Prueba");
		nuevaUrna.addVoto(nuevoVoto);
		gestorPrincipal.addUrnaElectoral(nuevaUrna);

		Assert.assertEquals(1, gestorPrincipal.cantidadDeVotosRegistrados());
		
	}
	
	@Test
	public void candidatoConMasVotosObetnidosANivelNacional(){
		
		String provinciaUno = "Buenos Aires";
		String provinciaDos = "Santa fe";
		
		Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Candidato Uno","Partido Uno");
        PosiblesCandidatos.put("Candidato Dos","Partido Dos");
        
    	Voto votoUno = new Voto(PosiblesCandidatos);
    	Voto votoDos = new Voto(PosiblesCandidatos);
    	Voto votoTres = new Voto(PosiblesCandidatos);
    	Voto votoCuatro = new Voto(PosiblesCandidatos);
    	Voto votoCinco = new Voto(PosiblesCandidatos);
        UrnaElectoral urnaUno = new UrnaElectoral(provinciaUno);
        UrnaElectoral urnaDos = new UrnaElectoral(provinciaDos);
    	
        votoUno.setCandidatoYPartido("Candidato Uno","Partido Uno");
        votoDos.setCandidatoYPartido("Candidato Dos","Partido Dos");
        votoTres.setCandidatoYPartido("Candidato Uno","Partido Uno");
        votoCuatro.setCandidatoYPartido("Candidato Uno","Partido Uno");
        votoCinco.setCandidatoYPartido("Candidato Dos","Partido Dos");
        
        urnaUno.addVoto(votoUno);
        urnaUno.addVoto(votoDos);
        
        urnaDos.addVoto(votoTres);
        urnaDos.addVoto(votoCuatro);
        urnaDos.addVoto(votoCinco);
        
        gestorPrincipal.addUrnaElectoral(urnaUno);
        gestorPrincipal.addUrnaElectoral(urnaDos);
		String ganadorANivelNacional = gestorPrincipal.candidatoConMasVotosObetnidosANivelNacional();
		
		Assert.assertEquals("Candidato Uno", ganadorANivelNacional);
		
	}
	
	@Test
	public void partidoConMasVotosEnProvinciaDada(){

		Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Candidato Uno","Partido Uno");
        PosiblesCandidatos.put("Candidato Dos","Partido Dos");
        
    	Voto votoUno = new Voto(PosiblesCandidatos);
    	Voto votoDos = new Voto(PosiblesCandidatos);
    	Voto votoTres = new Voto(PosiblesCandidatos);
    	Voto votoCuatro = new Voto(PosiblesCandidatos);
    	Voto votoCinco = new Voto(PosiblesCandidatos);
    	
        UrnaElectoral urnaUno = new UrnaElectoral("Buenos Aires");
        UrnaElectoral urnaDos = new UrnaElectoral("San Luis");
    	
        votoUno.setCandidatoYPartido("Candidato Dos","Partido Dos");
        votoDos.setCandidatoYPartido("Candidato Dos","Partido Dos");
        votoTres.setCandidatoYPartido("Candidato Uno","Partido Uno");
        votoCuatro.setCandidatoYPartido("Candidato Uno","Partido Uno");
        votoCinco.setCandidatoYPartido("Candidato Dos","Partido Dos");
        
        urnaUno.addVoto(votoUno);
        urnaUno.addVoto(votoDos);
        
        urnaDos.addVoto(votoTres);
        urnaDos.addVoto(votoCuatro);
        urnaDos.addVoto(votoCinco);
        
        gestorPrincipal.addUrnaElectoral(urnaUno);
        gestorPrincipal.addUrnaElectoral(urnaDos);
        
        String partidoGanadorEnProvincia = gestorPrincipal.PartidoEnProvincia("San Luis");
        Assert.assertEquals("Partido Uno", partidoGanadorEnProvincia);
        
	}
	
}
