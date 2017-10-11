package Ex;

import java.util.Objects;

import static Ex.Circle.r;
import static Ex.Rectangle.*;

class Calc {

    String areaType;

    void calcArea() {
        if (Objects.equals(areaType, "circle")) {
            System.out.println("Circle area is; " + (Math.PI * Math.pow(r, 2)));
        } else if (Objects.equals(areaType, "rectangle")) {
            System.out.println("Rectangle area is; " + (a * b));
        } else {
            System.out.println("Invalid shape");
        }
    }

    static void area(Object shape) {
        if (shape.getClass() == Circle.class) {
            System.out.println("Circle class call area is; " + (Math.PI * Math.pow(r, 2)));
        } else if (shape.getClass() == Rectangle.class) {
            System.out.println("Rectangle class call area is; " + (a * b));
        } else {
            System.out.println("Invalid class call shape");
        }
    }
}