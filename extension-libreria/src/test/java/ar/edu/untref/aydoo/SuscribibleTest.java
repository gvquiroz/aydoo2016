package ar.edu.untref.aydoo;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Velonter on 4/26/2016.
 */
public class SuscribibleTest {
    @Test
    public void agregoSuscripcionSinDescuento(){
        Suscribible miRevista = new PublicacionPeriodica("Teens",10,2);
        miRevista.setSuscripcionMensual();
        double valorEsperado = 20.0;

        Assert.assertEquals(valorEsperado,miRevista.getValor());
    }
    @Test
    public void agregoSuscripcionConDescuento(){
        Suscribible miRevista = new PublicacionPeriodica("Teens",10,2);
        miRevista.agregarDescuento();
        miRevista.setSuscripcionMensual();
        double valorEsperado = 16.0;

        Assert.assertEquals(valorEsperado,miRevista.getValor());
    }

    @Test
    public void agregoSuscripcionConDescuentoBasico(){
        Suscribible miRevista = new PublicacionPeriodica("Teens",10,1);
        miRevista.agregarDescuento();
        miRevista.setSuscripcionMensual();
        double valorEsperado = 8.0;

        Assert.assertEquals(valorEsperado,miRevista.getValor());
    }
}
