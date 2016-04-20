package ar.edu.untref.aydoo;

public class GestorDeOpcionesDeInterfaz {
	
	private String formato = "pretty";
	private String nombreDeArchivo = null;
	private String tipoDeOrdenamiento = "des";
	private boolean imprime = false;
	
	public GestorDeOpcionesDeInterfaz (String args[]){
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
	}
	
	public String getFormato(){
		return this.formato;
	}
	public String getNombreDeArchivo(){
		return this.nombreDeArchivo;
	}
	public String getTipoDeOrdenamiento(){
		return this.tipoDeOrdenamiento;
	}
	public boolean isImprime(){
		return this.imprime;
	}
}
