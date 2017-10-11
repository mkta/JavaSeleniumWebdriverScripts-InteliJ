package Ex;

public class Pizza extends Produs {



    @Override
    public double calcularePret() {
        return (pretBaza + pretBaza*0.10);
    }
}
