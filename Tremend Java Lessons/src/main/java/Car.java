public class Car {
    private int id;
    private String model;
    private double maximumSpeed;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public double getMaximumSpeed() {
        return this.maximumSpeed;
    }

    @Override
    public String toString() {
        return this.id + " " + this.model + " " + this.maximumSpeed;
    }
}