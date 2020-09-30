import java.util.Observable;

public class estacion extends Observable {
    private double temp;

    public void addData(Double amount) {
        this.temp += amount;
        setChanged();
        notifyObservers(temp);
    }

    public Double getData() {
        return temp;
    }
}
