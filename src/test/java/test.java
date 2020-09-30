import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;

public class test {
    @Test
    public void test_get_data_single() {
        estacion estacion_principal = new estacion();
        cliente nuevoCliente = new cliente();
        nuevoCliente.getData(es);
    }

    @Test
    public void test_get_data_multiple() {

    }

    @Test
    public void test_data_changes_single() {

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
