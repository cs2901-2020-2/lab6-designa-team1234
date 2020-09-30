import java.util.Observable;

public class cliente implements Observer{
    private int id;
    private double []datos = new double[3];
    public cliente(int id) {
        this.id = id;
    }

    public void update(Observable estacion, Object values) {
        this.datos = (double []) values;
    }

    public double[] getData() {
        return datos;
    }
}