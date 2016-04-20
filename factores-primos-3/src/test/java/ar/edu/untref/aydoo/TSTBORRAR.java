package ar.edu.untref.aydoo;

import org.junit.Test;

public class TSTBORRAR {


	@Test
	public void probandoReconocimientoYSplit(){
		String args[] = {"--format=quiett", "--sort:des", "--output-file=salida.txt"};
		
		String formato = "";
		String nombreDeArchivo = "";
		String tipoDeOrdenamiento = "";
		boolean imprime = false;
		
		for (String datos: args){
			if (datos.contains("--format=")){
				String[] descomposicionDeFormato = datos.split("=");
				formato = descomposicionDeFormato[1];
			} else if (datos.contains("--output-file=")){
				String[] descomposicionDeOutput = datos.split("=");
				nombreDeArchivo = descomposicionDeOutput[1];
				imprime = true;
			} else if (datos.contains("--sort:")){
				String[] descomposicionDeOrden = datos.split(":");
				tipoDeOrdenamiento = descomposicionDeOrden[1];
			}
		}
		
		if (imprime){
			System.out.println("Guarda en archivo");
		} else {
			System.out.println("Imprime por pantalla");
		}
		System.out.println(formato);
		System.out.println(nombreDeArchivo);
		System.out.println(tipoDeOrdenamiento);
	}

}
