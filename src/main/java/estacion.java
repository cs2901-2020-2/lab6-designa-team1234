import java.util.Observable;

public class estacion extends Observable {
    private Double[] datos;

    public void addData(Double temp, Double humidity, Double windspeed) {
        setChanged();
        Double[] datos = {temp, humidity, windspeed};
        notifyObservers(datos);
    }

    public Double[] getData() {
        return datos;
    }
}
