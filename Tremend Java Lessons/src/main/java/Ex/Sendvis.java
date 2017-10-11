package Ex;

public class Sendvis extends Produs {

    @Override
    public double calcularePret() {
        return (pretBaza + pretBaza*0.15);
    }

}

