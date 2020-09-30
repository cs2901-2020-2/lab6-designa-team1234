import java.util.Observable;

public class EstacionMeteorologica extends Observable {

    private final double[] datos = new double[3];

    public void addData(double temp, double humidity, double windspeed) {
        setChanged();
        datos[0] = temp;
        datos[1] = humidity;
        datos[2] = windspeed;
        notifyObservers(datos);
    }

    public double[] getData() {
        return datos;
    }
}
