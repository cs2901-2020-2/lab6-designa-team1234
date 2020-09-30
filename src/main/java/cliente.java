import java.util.Observable;

public class cliente {
    private String type;
    private Double totalCalculated = new Double(0D);
    private final Double rateCoefficient;

    public void BankExpense(String type, Double rateCoefficient) {
        this.type = type;
        this.rateCoefficient = rateCoefficient;
    }

    @Override
    public void update(Observable o, Object value) {
        this.totalCalculated = ((Double) value) * rateCoefficient;
    }

    public Double getTotalCalculated() {
        return totalCalculated;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "BankExpense{" +
                "type='" + type + '\'' +
                ", rateCoefficient=" + rateCoefficient +
                ", totalCalculated=" + totalCalculated +
                '}';
    }
}