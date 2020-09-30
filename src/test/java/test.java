import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;

public class test {
    @Test
    public void test_get_data_single() {
        estacion estacion_principal = new estacion();
        cliente nuevoCliente = new cliente();
        estacion_principal.addData(32.0,43.33,56.0);
        estacion_principal.addObserver(nuevoCliente);

        Assert.assertEquals(nuevoCliente.getData() = estacion_principal.getData());
    }

    @Test
    public void test_get_data_multiple() {
        estacion estacion_principal = new estacion();
        cliente nuevoCliente0 = new cliente();
        cliente nuevoCliente1 = new cliente();
        cliente nuevoCliente2 = new cliente();
        cliente nuevoCliente3 = new cliente();
        cliente nuevoCliente4 = new cliente();

        estacion_principal.addData(32.0,43.33,56.0);
        estacion_principal.addObserver(nuevoCliente0);
        estacion_principal.addObserver(nuevoCliente1);
        estacion_principal.addObserver(nuevoCliente2);
        estacion_principal.addObserver(nuevoCliente3);
        estacion_principal.addObserver(nuevoCliente4);

        Assert.assertEquals(nuevoCliente0.getData() = estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData() = estacion_principal.getData());
        Assert.assertEquals(nuevoCliente2.getData() = estacion_principal.getData());
        Assert.assertEquals(nuevoCliente3.getData() = estacion_principal.getData());
        Assert.assertEquals(nuevoCliente4.getData() = estacion_principal.getData());
    }

    @Test
    public void test_data_changes_single() {
        estacion estacion_principal = new estacion();
        cliente nuevoCliente0 = new cliente();
        estacion_principal.addObserver(nuevoCliente0);

        estacion_principal.addData(32.0,43.33,56.0);
        Assert.assertEquals(nuevoCliente0.getData() = estacion_principal.getData());
        estacion_principal.addData(27.0,80.34,23.4);
        Assert.assertEquals(nuevoCliente0.getData() = estacion_principal.getData());
        estacion_principal.addData(23.2,55.33,16.0);
        Assert.assertEquals(nuevoCliente0.getData() = estacion_principal.getData());
    }

    @Test
    public void test_data_changes_multiple() {

    }

    @Test
    public void tetst_data_create_single() {

    }

    @Test
    public void test_data_create_multiple() {

    }
}
