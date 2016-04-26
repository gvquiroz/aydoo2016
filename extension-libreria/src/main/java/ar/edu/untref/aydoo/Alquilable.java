package ar.edu.untref.aydoo;

/**
 * Created by Velonter on 4/25/2016.
 */
public interface Alquilable extends ActivosKiosko{
    public void setAlquilerEnDias(int cantidadDeDias);
    public void setAlquilerEnMeses();
    public void setAlquilerEnCuatrimestres();
}
