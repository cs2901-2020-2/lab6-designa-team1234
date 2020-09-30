import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class test {
    @Test
    public void test_get_data_single() {
        EstacionMeteorologica estacion_principal = new EstacionMeteorologica();
        Cliente nuevoCliente = new Cliente(0);
        estacion_principal.addObserver(nuevoCliente);
        estacion_principal.addData(32.0,43.33,56.0);

        Assert.assertEquals(nuevoCliente.getData(), estacion_principal.getData());
    }

    @Test
    public void test_get_data_multiple() {
        EstacionMeteorologica estacion_principal = new EstacionMeteorologica();
        Cliente nuevoCliente0 = new Cliente(0);
        Cliente nuevoCliente1 = new Cliente(1);
        Cliente nuevoCliente2 = new Cliente(2);
        Cliente nuevoCliente3 = new Cliente(3);
        Cliente nuevoCliente4 = new Cliente(4);

        estacion_principal.addObserver(nuevoCliente0);
        estacion_principal.addObserver(nuevoCliente1);
        estacion_principal.addObserver(nuevoCliente2);
        estacion_principal.addObserver(nuevoCliente3);
        estacion_principal.addObserver(nuevoCliente4);

        estacion_principal.addData(32.0,43.33,56.0);

        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente2.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente3.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente4.getData(), estacion_principal.getData());
    }

    @Test
    public void test_data_changes_single() {
        EstacionMeteorologica estacion_principal = new EstacionMeteorologica();
        Cliente nuevoCliente0 = new Cliente(1);
        estacion_principal.addObserver(nuevoCliente0);

        estacion_principal.addData(32.0,43.33,56.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        estacion_principal.addData(27.0,80.34,23.4);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        estacion_principal.addData(23.2,55.33,16.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
    }

    @Test
    public void test_data_changes_multiple() {
        EstacionMeteorologica estacion_principal = new EstacionMeteorologica();
        Cliente nuevoCliente0 = new Cliente(0);
        Cliente nuevoCliente1 = new Cliente(1);
        Cliente nuevoCliente2 = new Cliente(2);
        Cliente nuevoCliente3 = new Cliente(3);
        Cliente nuevoCliente4 = new Cliente(4);

        estacion_principal.addObserver(nuevoCliente0);
        estacion_principal.addObserver(nuevoCliente1);
        estacion_principal.addObserver(nuevoCliente2);
        estacion_principal.addObserver(nuevoCliente3);
        estacion_principal.addObserver(nuevoCliente4);

        estacion_principal.addData(32.0,43.33,56.0);

        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente2.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente3.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente4.getData(), estacion_principal.getData());

        estacion_principal.addData(22.0,48.4,53.0);

        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente2.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente3.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente4.getData(), estacion_principal.getData());

        estacion_principal.addData(29.0,77.33,46.0);

        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente2.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente3.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente4.getData(), estacion_principal.getData());

    }

    @Test
    public void tetst_data_create_single() {
        EstacionMeteorologica estacion_principal = new EstacionMeteorologica();
        Cliente nuevoCliente0 = new Cliente(0);
        estacion_principal.addObserver(nuevoCliente0);
        Cliente nuevoCliente1 = new Cliente(1);

        estacion_principal.addData(32.0,43.33,56.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());

        estacion_principal.addObserver(nuevoCliente1);

        estacion_principal.addData(27.0,80.34,23.4);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());

        estacion_principal.addData(23.2,55.33,16.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());
    }

    @Test
    public void test_data_create_multiple() {
        EstacionMeteorologica estacion_principal = new EstacionMeteorologica();
        Cliente nuevoCliente0 = new Cliente(0);
        estacion_principal.addObserver(nuevoCliente0);

        estacion_principal.addData(32.0,43.33,56.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());

        Cliente nuevoCliente1 = new Cliente(1);
        estacion_principal.addObserver(nuevoCliente1);

        estacion_principal.addData(27.0,80.34,23.4);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());

        Cliente nuevoCliente2 = new Cliente(2);
        estacion_principal.addObserver(nuevoCliente2);

        estacion_principal.addData(23.2,55.33,16.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente2.getData(), estacion_principal.getData());

    }

    @Test
    public void UpdateClientTest() {
        EstacionMeteorologica estacionMetereologica = new EstacionMeteorologica();
        Cliente client1 = new Cliente(1);
        Cliente client2 = new Cliente(2);
        estacionMetereologica.addObserver(client1);
        estacionMetereologica.addObserver(client2);

        estacionMetereologica.addData(23.4,12.2,43.2);
        double[] getValue = client1.getData();
        Assert.assertEquals(getValue[0], 23.4);
        Assert.assertEquals(getValue[1], 12.2);
        Assert.assertEquals(getValue[2], 43.2);

        Cliente client3 = new Cliente(3);
        estacionMetereologica.addObserver(client3);
        estacionMetereologica.addData(54.5,12.2,56.1);
        double[] getValue2 = client3.getData();
        Assert.assertEquals(getValue2[0], 54.5);
        Assert.assertEquals(getValue2[1], 12.2);
        Assert.assertEquals(getValue2[2], 56.1);
    }

}

