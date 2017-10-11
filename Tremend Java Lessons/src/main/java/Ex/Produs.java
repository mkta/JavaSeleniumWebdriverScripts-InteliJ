package Ex;

import java.util.Arrays;

abstract public class Produs {

    public int tipProdus;
    String nume;
    double pretBaza;
    String[] adaosuri = new String[10];


    private String introducereAdaosuri() {

        return Arrays.toString(adaosuri)
                .replace("[", "")
                .replace("]", "");
    }


    private String toateAdaosurile() {


        if (adaosuri[0] != null) {
            return introducereAdaosuri();
        } else {
            return "Fara adaosuri";

        }
    }

    abstract public double calcularePret();

    @Override
    public String toString() {
        return "Produs: " +
                nume +
                ", " +
                "pret: " +
                calcularePret() +
                ", " +
                "adaosuri: " +
                toateAdaosurile();
    }
}

