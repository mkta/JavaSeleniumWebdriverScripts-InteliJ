package Ex;

public class Car {
    public Car() {
        System.out.println("Car created");
    }

    public Car(String filename) {
        System.out.println(filename + " created");
    }

    String make;
    String model;
    int numDoors;


    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Car(String make, String model, int nDoors) {
        this.make = make;
        this.model = model;
        numDoors = nDoors;
        System.out.println(make + "_" + model + "_" + nDoors);
    }

    public void printDetails() {
        System.out.println("Make " + make);
        System.out.println("Model " + model);
        System.out.println("Number of doors " + numDoors);
    }
}

