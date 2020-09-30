import java.util.Random;
public class RandomNumbers {
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int viento = r.nextInt(10)+39;
        int temperatura = r.nextInt(25) + 15;
        double humedad = r.nextDouble()*100;
        System.out.println((viento));
        System.out.println(temperatura);
        System.out.println(redondearDecimales(humedad,2));

    }
}
