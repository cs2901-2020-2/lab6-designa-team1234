import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class test {
    @Test
    public void test_get_data_single() {
        estacion estacion_principal = new estacion();
        cliente nuevoCliente = new cliente(0);
        estacion_principal.addData(32.0,43.33,56.0);
        estacion_principal.addObserver(nuevoCliente);

        Assert.assertEquals(nuevoCliente.getData(), estacion_principal.getData());
    }

    @Test
    public void test_get_data_multiple() {
        estacion estacion_principal = new estacion();
        cliente nuevoCliente0 = new cliente(0);
        cliente nuevoCliente1 = new cliente(1);
        cliente nuevoCliente2 = new cliente(2);
        cliente nuevoCliente3 = new cliente(3);
        cliente nuevoCliente4 = new cliente(4);

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
        estacion estacion_principal = new estacion();
        cliente nuevoCliente0 = new cliente(1);
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
        estacion estacion_principal = new estacion();
        cliente nuevoCliente0 = new cliente(0);
        cliente nuevoCliente1 = new cliente(1);
        cliente nuevoCliente2 = new cliente(2);
        cliente nuevoCliente3 = new cliente(3);
        cliente nuevoCliente4 = new cliente(4);

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
        estacion estacion_principal = new estacion();
        cliente nuevoCliente0 = new cliente(0);
        estacion_principal.addObserver(nuevoCliente0);
        cliente nuevoCliente1 = new cliente(1);

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
        estacion estacion_principal = new estacion();
        cliente nuevoCliente0 = new cliente(0);
        estacion_principal.addObserver(nuevoCliente0);

        estacion_principal.addData(32.0,43.33,56.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());

        cliente nuevoCliente1 = new cliente(1);
        estacion_principal.addObserver(nuevoCliente1);

        estacion_principal.addData(27.0,80.34,23.4);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());

        cliente nuevoCliente2 = new cliente(2);
        estacion_principal.addObserver(nuevoCliente2);

        estacion_principal.addData(23.2,55.33,16.0);
        Assert.assertEquals(nuevoCliente0.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente1.getData(), estacion_principal.getData());
        Assert.assertEquals(nuevoCliente2.getData(), estacion_principal.getData());

    }

    @Test(expectedExceptions = Exception.class)
    public void UpdateClientTest() throws Exception{
        estacion estacionMetereologica = new estacion();
        cliente client1 = new cliente(1);
        cliente client2 = new cliente(2);
        estacionMetereologica.addData(23.4,12.2,43.2);
        double[] getValue = client1.getData();
        Assert.assertEquals(getValue[0], 23.4);
        Assert.assertEquals(getValue[1], 12.2);
        Assert.assertEquals(getValue[2], 43.2);
        estacionMetereologica.addData(54.5,12.2,56.1);
        cliente client3 = new cliente(3);
        double[] getValue2 = client3.getData();
        Assert.assertEquals(getValue2[0], 54.5);
        Assert.assertEquals(getValue2[1], 12.2);
        Assert.assertEquals(getValue2[2], 56.1);
    }

    private List<String> readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines;
    }

    private List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}

