package ar.edu.untref.aydoo;

public class PublicacionPeriodica extends Producto implements Suscribible {


    private final int periodicidadMensual;
    private boolean suscripcion;
    private boolean tieneDescuento;

    public PublicacionPeriodica(String nombre, double monto, int nuevaPeriodicidadMensual) {
        super(nombre, monto);
        this.periodicidadMensual = nuevaPeriodicidadMensual;
        this.tieneDescuento = false;
    }

    @Override
    public void setSuscripcionMensual() {

        if (tieneDescuento) {
            double productoConDescuento = this.getValor() - (this.getValor() * 0.2);
            this.setValor(this.periodicidadMensual * productoConDescuento);
        } else {
            this.setValor(this.periodicidadMensual * this.getValor());
        }
        this.suscripcion = true;
    }

    @Override
    public void agregarDescuento() {
        this.tieneDescuento = true;
    }

}
