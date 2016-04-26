package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Velonter on 4/26/2016.
 */
public class AlquilableTest {
    @Test
    public void testCalculandoPrecioDeProductoAlquiladoEnQuinceDias(){
        Alquilable nuevoLibro = new Libro("The way of the superior man", 15);
        nuevoLibro.setAlquilerEnDias(15);
        int valorEsperado = 150;

        Assert.assertEquals(valorEsperado, nuevoLibro.getValor(),.0);
    }
    @Test
    public void testCalculandoPrecioDeProductoAlquiladoEnDiezDias(){
        Alquilable nuevoLibro = new Libro("The way of the superior man", 15);
        nuevoLibro.setAlquilerEnDias(10);
        int valorEsperado = 100;

        Assert.assertEquals(valorEsperado, nuevoLibro.getValor(),.0);
    }
    @Test
    public void testCalculandoPrecioDeProductoAlquiladoEnTresDias(){
        Alquilable nuevoLibro = new Libro("The way of the superior man", 15);
        nuevoLibro.setAlquilerEnDias(3);
        int valorEsperado = 30;

        Assert.assertEquals(valorEsperado, nuevoLibro.getValor(),.0);
    }
    @Test (expected = CantidadDeDiasInvalidoException.class)
    public void testCalculandoPrecioDeProductoAlquiladoEnUnDia(){
        Alquilable nuevoLibro = new Libro("The way of the superior man", 15);
        nuevoLibro.setAlquilerEnDias(1);

    }
    @Test (expected = CantidadDeDiasInvalidoException.class)
    public void testCalculandoPrecioDeProductoAlquiladoEnCuarentaDias(){
        Alquilable nuevoLibro = new Libro("The way of the superior man", 15);
        nuevoLibro.setAlquilerEnDias(40);
    }
    @Test
    public void testCalculandoPrecioDeProductoEnUnMes(){
        Alquilable nuevoLibro = new Libro("The way of the superior man", 15);
        nuevoLibro.setAlquilerEnMeses(1);
        int valorEsperado = 200;
        Assert.assertEquals(valorEsperado, nuevoLibro.getValor(),.0);
    }
    @Test
    public void testCalculandoPrecioDeProductoEnDosMeses(){
        Alquilable nuevoLibro = new Libro("The way of the superior man", 15);
        nuevoLibro.setAlquilerEnMeses(2);
        int valorEsperado = 400;
        Assert.assertEquals(valorEsperado, nuevoLibro.getValor(),.0);
    }
}
