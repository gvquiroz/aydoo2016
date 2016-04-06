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
	private String Provincia;

	@Before 
    public void initialize() {
    	Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Gabi","Partido Prueba");
    	Provincia = "Buenos Aires";
        
        nuevaUrna = new UrnaElectoral(Provincia);
        nuevoVoto = new Voto(PosiblesCandidatos);
        gestorPrincipal = new GestorDeVotosElectorales();
     }
	
	@Test
	public void EmisionDelVoto(){
		nuevoVoto.setCandidatoYPartido("Gabi","Partido Prueba");
		nuevaUrna.addVoto(nuevoVoto);
		gestorPrincipal.addUrnaElectoral(nuevaUrna);
		/*
		 * Terminar
		 */
	}
	
	@Test
	public void candidatoConMasVotosObetnidosANivelNacional(){
		
		String provinciaUno = "Buenos Aires";
		String provinciaDos = "Santa fe";
		
		Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Candidato Uno","Partido Uno");
        PosiblesCandidatos.put("Candidato Dos","Partido Dos");
        
    	Voto VotoUno = new Voto(PosiblesCandidatos);
    	Voto VotoDos = new Voto(PosiblesCandidatos);
    	Voto VotoTres = new Voto(PosiblesCandidatos);
    	Voto VotoCuatro = new Voto(PosiblesCandidatos);
    	Voto VotoCinco = new Voto(PosiblesCandidatos);
        UrnaElectoral UrnaUno = new UrnaElectoral(provinciaUno);
        UrnaElectoral UrnaDos = new UrnaElectoral(provinciaDos);
    	
        VotoUno.setCandidatoYPartido("Candidato Uno","Partido Uno");
        VotoDos.setCandidatoYPartido("Candidato Dos","Partido Dos");
        VotoTres.setCandidatoYPartido("Candidato Uno","Partido Uno");
        VotoCuatro.setCandidatoYPartido("Candidato Uno","Partido Uno");
        VotoCinco.setCandidatoYPartido("Candidato Dos","Partido Dos");
        
        UrnaUno.addVoto(VotoUno);
        UrnaUno.addVoto(VotoDos);
        
        UrnaDos.addVoto(VotoTres);
        UrnaDos.addVoto(VotoCuatro);
        UrnaDos.addVoto(VotoCinco);
        
        gestorPrincipal.addUrnaElectoral(UrnaUno);
        gestorPrincipal.addUrnaElectoral(UrnaDos);
		String ganadorANivelNacional = gestorPrincipal.candidatoConMasVotosObetnidosANivelNacional();
		
		Assert.assertEquals("Candidato Uno", ganadorANivelNacional);
	}
	
	@Test
	public void PartidoConMasVotosEnProvinciaDada(){
		String provinciaUno = "Buenos Aires";
		String provinciaDos = "Santa fe";
		
		Map<String,String> PosiblesCandidatos = new HashMap<>();
        PosiblesCandidatos.put("Candidato Uno","Partido Uno");
        PosiblesCandidatos.put("Candidato Dos","Partido Dos");
        
    	Voto VotoUno = new Voto(PosiblesCandidatos);
    	Voto VotoDos = new Voto(PosiblesCandidatos);
    	Voto VotoTres = new Voto(PosiblesCandidatos);
    	Voto VotoCuatro = new Voto(PosiblesCandidatos);
    	Voto VotoCinco = new Voto(PosiblesCandidatos);
        UrnaElectoral UrnaUno = new UrnaElectoral(provinciaUno);
        UrnaElectoral UrnaDos = new UrnaElectoral(provinciaDos);
    	
        VotoUno.setCandidatoYPartido("Candidato Uno","Partido Uno");
        VotoDos.setCandidatoYPartido("Candidato Dos","Partido Dos");
        VotoTres.setCandidatoYPartido("Candidato Uno","Partido Uno");
        VotoCuatro.setCandidatoYPartido("Candidato Uno","Partido Uno");
        VotoCinco.setCandidatoYPartido("Candidato Dos","Partido Dos");
        
        UrnaUno.addVoto(VotoUno);
        UrnaUno.addVoto(VotoDos);
        
        UrnaDos.addVoto(VotoTres);
        UrnaDos.addVoto(VotoCuatro);
        UrnaDos.addVoto(VotoCinco);
        
        gestorPrincipal.addUrnaElectoral(UrnaUno);
        gestorPrincipal.addUrnaElectoral(UrnaDos);
	}
	
}
