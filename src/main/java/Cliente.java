import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer{
    private int clientId;
    private double []datos = new double[3];
    public Cliente(int id) {
        clientId = id;
    }

    public void update(Observable estacion, Object values) {
        this.datos = (double []) values;
    }

    public double[] getData() {
        return datos;
    }

    public int getClientId () {
        return clientId;
    }
}

