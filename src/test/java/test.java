import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Test
class EstacionMetereologicaTest{

    @Test(expectedExceptions = Exception.class)
    void pushUserTest() throws Exception{
        Integer COUNT_USER = 2;
        EstacionMetereologica estacionMetereologica = new EstacionMeterologica();
        Client client1 = new client(1);
        Client client2 = new client(2);
        estacionMetereologica.addObserver(client1);
        estacionMetereologica.addObserver(Cliente2);
        Integer getCountUser = estacionMetereologica.totalClients();
        Assert.assertEquals(getCountUser == COUNT_USER);
    }

    @Test(expectedExceptions = Exception.class)
    public void UpdateClientTest() throws Exception{
        EstacionMetereologica estacionMetereologica = new EstacionMeterologica();
        Client client1 = new client(1);
        Client client2 = new client(2);
        EstacionMetereologica.UpdateData(23.4,12.2,43.2);
        double[] getValue = client1.getData();
        Assert.assertEquals(getValue[0] == 23.4);
        Assert.assertEquals(getValue[1] == 12.2);
        Assert.assertEquals(getValue[2] == 43.2);
        EstacionMetereologica.UpdateData(54.5,12.2,56.1);
        Client client3 = new client(3);
        double[] getValue2 = client3.getData();
        Assert.assertEquals(getValue2[0] == 54.5);
        Assert.assertEquals(getValue2[1] == 12.2);
        Assert.assertEquals(getValue2[2] == 56.1);
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