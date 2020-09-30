import java.util.Observable;

public class estacion extends Observable {
    private double[] datos;

    public void addData(double temp, double humidity, double windspeed) {
        setChanged();
        double[] datos = {temp, humidity, windspeed};
        notifyObservers(datos);
    }

    public double[] getData() {
        return datos;
    }
}
