package Ex;

public class Square extends Shape {
    private int squareSideSize;

    public void squareArea() {
        System.out.println("Square area:" + Math.pow(squareSideSize, 2));
    }

}
