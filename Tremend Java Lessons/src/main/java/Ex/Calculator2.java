package Ex;

public class Calculator2 implements Operands, Operations {

    public double a;
    private double b;

    @Override
    public void setOperands(double a, double b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public double add() {
        return a + b;
    }

    @Override
    public double sub() {
        return a - b;
    }
}
