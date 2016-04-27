package ar.edu.untref.aydoo;

public class Producto implements ActivosKiosko {

    private double valor;
    private String nombre;

    public Producto(String nombre, double monto) {
        this.valor = monto;
        this.nombre = nombre;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public String getNombre() {
        return nombre;
    }
}
