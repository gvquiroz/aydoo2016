package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class GestorDeVotosElectorales {

	List<UrnaElectoral> UrnasElectorales = new LinkedList<>();
	public void addUrnaElectoral(UrnaElectoral nuevaUrna) {
		this.UrnasElectorales.add(nuevaUrna);
	}
	
	public int cantidadDeUrnasElectoralesRegistradas(){
		return this.UrnasElectorales.size();
	}

}
