package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class IntegracionTest {

    @Test
    public void testCasoClienteNoEncontrado() {

        Kiosko elKiosko = new Kiosko();
        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Cliente jose = new Cliente("José", "Av. Roca 531");

        Assert.assertEquals("Cliente no encontrado",
                elKiosko.calcularMontoACobrar("Febrero", jose));
    }

    @Test
    public void testVentaDeUnLibroEnEnero() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Producto producto1 = new Libro("El Hobbit", 50);

        juan.comprar(producto1, "Enero");

        Assert.assertEquals("Monto a cobrarle por enero: 50.0 = $50.0",
                elKiosko.calcularMontoACobrar("Enero", juan));
    }

    @Test
    public void testVentaDeUnLibroEnEneroyFebrero() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Producto producto1 = new Libro("El Hobbit", 50);

        Producto producto2 = new Libro("La Metamorfosis", 70);

        juan.comprar(producto1, "Enero");
        juan.comprar(producto2, "Febrero");

        Assert.assertEquals("Monto a cobrarle por febrero: 70.0 = $70.0",
                elKiosko.calcularMontoACobrar("Febrero", juan));
    }

    @Test
    public void testVentaDeDosLibrosEnFebrero() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Producto producto1 = new Libro("El Hobbit", 50);

        Producto producto2 = new Libro("La Metamorfosis", 70);

        juan.comprar(producto1, "Febrero");
        juan.comprar(producto2, "Febrero");

        Assert.assertEquals("Monto a cobrarle por febrero: 50.0 + 70.0 = $120.0",
                elKiosko.calcularMontoACobrar("Febrero", juan));
    }

    @Test
    public void testVentaDeDosLibrosYDosLapicerasEnFebrero() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Producto producto1 = new Libro("El Hobbit", 50);

        Producto producto2 = new Libro("La Metamorfosis", 70);

        Producto producto3 = new ArticuloLibreria("LapiceraBic", 5, 2);

        juan.comprar(producto1, "Febrero");
        juan.comprar(producto2, "Febrero");
        juan.comprar(producto3, "Febrero");

        Assert.assertEquals("Monto a cobrarle por febrero: 50.0 + 70.0 + 12.1 = $132.1",
                elKiosko.calcularMontoACobrar("Febrero", juan));
    }

    @Test
    public void testVentaAMasDeUnClienteEnFebrero() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        Cliente pedro = new Cliente("Pedro", "Av. Libertador 4631");

        elKiosko.agregarCliente(juan);
        elKiosko.agregarCliente(pedro);

        Producto producto1 = new Libro("El Hobbit", 50);

        Producto producto2 = new Libro("La Metamorfosis", 70);

        Producto producto3 = new ArticuloLibreria("LapiceraBic", 5, 2);

        juan.comprar(producto1, "Enero");
        juan.comprar(producto2, "Febrero");
        juan.comprar(producto3, "Febrero");

        pedro.comprar(producto3, "Febrero");

        Assert.assertEquals("Monto a cobrarle por febrero: 12.1 = $12.1",
                elKiosko.calcularMontoACobrar("Febrero", pedro));
    }

    @Test
    public void testVentaSoloPeriodicoFebrero() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Producto producto1 = new PublicacionPeriodica("Clarín", 13, 30);

        juan.comprar(producto1, "Febrero");

        Assert.assertEquals("Monto a cobrarle por febrero: 13.0 = $13.0",
                elKiosko.calcularMontoACobrar("Febrero", juan));
    }

    @Test
    public void testSuscripcionPeriodicoFebrero() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Suscribible DiarioClarin = new PublicacionPeriodica("Clarín", 13, 30);

        juan.suscribirmeA(DiarioClarin, "Febrero", 3);

        Assert.assertEquals("Monto a cobrarle por febrero: 390.0 = $390.0",
                elKiosko.calcularMontoACobrar("Febrero", juan));
    }

    @Test
    public void testSuscripcionPeriodicoFebreroVerPrecioJunio() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Suscribible DiarioClarin = new PublicacionPeriodica("Clarín", 13, 30);

        juan.suscribirmeA(DiarioClarin, "Febrero", 10);

        Assert.assertEquals("Monto a cobrarle por junio: 390.0 = $390.0",
                elKiosko.calcularMontoACobrar("Junio", juan));
    }

    @Test
    public void testSuscripcionPeriodicoFebreroVerPrecioEnOtrosMes() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Suscribible DiarioClarin = new PublicacionPeriodica("Clarín", 13, 30);

        juan.suscribirmeA(DiarioClarin, "Febrero", 5);

        Assert.assertEquals("Monto a cobrarle por marzo: 390.0 = $390.0",
                elKiosko.calcularMontoACobrar("Marzo", juan));

    }

    @Test
    public void testSuscripcionPeriodicoFebreroMasLibro() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Suscribible DiarioClarin = new PublicacionPeriodica("Clarín", 13, 30);

        Producto producto2 = new Libro("La Metamorfosis", 70);

        juan.suscribirmeA(DiarioClarin, "Febrero", 2);
        juan.comprar(producto2, "Febrero");

        Assert.assertEquals("Monto a cobrarle por febrero: 390.0 + 70.0 = $460.0",
                elKiosko.calcularMontoACobrar("Febrero", juan));
    }

    @Test
    public void testSuscripcionRevistaMarzoVerPrecioEnOtrosMes() {

        Kiosko elKiosko = new Kiosko();
        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);
        Suscribible revistaSuscribible = new PublicacionPeriodica("Barcelona", 20, 2);

        juan.suscribirmeA(revistaSuscribible, "marzo", 3);

        Assert.assertEquals("Monto a cobrarle por marzo: 40.0 = $40.0",
                elKiosko.calcularMontoACobrar("Marzo", juan));

    }

    @Test
    public void testCompraUnaRevistaMarzo() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Producto producto1 = new PublicacionPeriodica("Barcelona", 20, 2);

        juan.comprar(producto1, "Marzo");

        Assert.assertEquals("Monto a cobrarle por marzo: 20.0 = $20.0",
                elKiosko.calcularMontoACobrar("Marzo", juan));

    }

    @Test
    public void testClienteCompraUnLibroUnArticuloYUnPeriodico() {

        Kiosko elKiosko = new Kiosko();

        Cliente juan = new Cliente("Juan", "Av. San Martin 5213");
        elKiosko.agregarCliente(juan);

        Producto producto1 = new Libro("El Hobbit", 50);

        Producto producto2 = new ArticuloLibreria("LapiceraBic", 5, 2);

        Producto producto3 = new PublicacionPeriodica("El Gráfico", 30, 30);

        juan.comprar(producto1, "Agosto");
        juan.comprar(producto2, "Agosto");
        juan.comprar(producto3, "Agosto");

        Assert.assertEquals("Monto a cobrarle por agosto: 50.0 + 12.1 + 30.0 = $92.1",
                elKiosko.calcularMontoACobrar("Agosto", juan));
    }

    @Test
    public void testSeSuscribeAUnaRevistaYCompraUnDiario() {

        Kiosko elKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        elKiosko.agregarCliente(maria);
        Suscribible revistaBarcelonaSuscripcion = new PublicacionPeriodica("Barcelona", 20, 2);
        Producto producto2 = new PublicacionPeriodica("Página 12", 12, 30);

        maria.suscribirmeA(revistaBarcelonaSuscripcion, "Enero", 12);
        maria.comprar(producto2, "Enero");

        Assert.assertEquals("Monto a cobrarle por enero: 32.0 + 12.0 = $44.0",
                elKiosko.calcularMontoACobrar("Enero", maria));
    }

    @Test
    public void testSuscripcionConDescuentoPrecioAPagarPorClienteEnOtroMes() {

        Kiosko elKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        elKiosko.agregarCliente(maria);
        Suscribible revistaBarcelonaSuscripcion = new PublicacionPeriodica("Barcelona", 20, 2);
        Producto producto2 = new PublicacionPeriodica("Página 12", 12, 30);

        maria.suscribirmeA(revistaBarcelonaSuscripcion, "Enero", 12);
        maria.comprar(producto2, "Enero");

        Assert.assertEquals("Monto a cobrarle por marzo: 32.0 = $32.0",
                elKiosko.calcularMontoACobrar("Marzo", maria));
    }

    @Test(expected = CantidadDeDiasInvalidoException.class)
    public void testAlquilarUnLibroTreintaDiasYArrojaUnaException() {

        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);

        maria.alquilarEnDias(elHobbit, "Enero", 30);
    }

    @Test(expected = CantidadDeDiasInvalidoException.class)
    public void testAlquilarUnLibroUnDiaYArrojaUnaException() {

        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);

        maria.alquilarEnDias(elHobbit, "Enero", 1);
    }

    @Test
    public void testAlquilarUnLibroVeinteDias() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);
        maria.alquilarEnDias(elHobbit, "Enero", 20);

        Assert.assertEquals("Monto a cobrarle por enero: 200.0 = $200.0",
                unKiosko.calcularMontoACobrar("Enero", maria));
    }

    @Test
    public void testAlquilarUnLibroDiezDias() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);
        maria.alquilarEnDias(elHobbit, "Enero", 10);

        Assert.assertEquals("Monto a cobrarle por enero: 100.0 = $100.0",
                unKiosko.calcularMontoACobrar("Enero", maria));
    }

    @Test
    public void testAlquilarUnLibroEnDosMeses() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);

        maria.alquilarEnMeses(elHobbit, "Enero", 2);

        Assert.assertEquals("Monto a cobrarle por enero: 200.0 = $200.0",
                unKiosko.calcularMontoACobrar("Enero", maria));
    }

    @Test
    public void testAlquilarUnLibroEnDosMesesYPreguntoPorElMesSiguiente() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);

        maria.alquilarEnMeses(elHobbit, "Enero", 2);

        Assert.assertEquals("Monto a cobrarle por febrero: 200.0 = $200.0",
                unKiosko.calcularMontoACobrar("Febrero", maria));
    }

    @Test
    public void testAlquilarUnLibroEnDosMesesYPreguntoPorLosTresMesesSiguientes() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);

        maria.alquilarEnMeses(elHobbit, "Enero", 2);

        Assert.assertEquals("Monto a cobrarle por marzo: = $0.0",
                unKiosko.calcularMontoACobrar("Marzo", maria));
    }

    @Test
    public void testAlquilarUnLibroPorUnCuatrimestre() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);

        maria.alquilarEnCuatrimestres(elHobbit, "Enero", 1);

        Assert.assertEquals("Monto a cobrarle por enero: 720.0 = $720.0",
                unKiosko.calcularMontoACobrar("Enero", maria));
    }

    @Test
    public void testAlquilarUnLibroPorDosCuatrimestresPreguntoEnElPrimerMesDelAlquiler() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);

        maria.alquilarEnCuatrimestres(elHobbit, "Enero", 2);

        Assert.assertEquals("Monto a cobrarle por enero: 640.0 = $640.0",
                unKiosko.calcularMontoACobrar("Enero", maria));
    }

    @Test
    public void testAlquilarUnLibroPorDosCuatrimestresPreguntoDentroDeCuatroMesesPorLaSegundaCuota() {
        Kiosko unKiosko = new Kiosko();
        Cliente maria = new Cliente("María", "Av. Alvarez Thomas 213");
        Alquilable elHobbit = new Libro("El Hobbit", 50);
        unKiosko.agregarCliente(maria);

        maria.alquilarEnCuatrimestres(elHobbit, "Enero", 2);

        Assert.assertEquals("Monto a cobrarle por mayo: 640.0 = $640.0",
                unKiosko.calcularMontoACobrar("Mayo", maria));
    }
}
