package ro.jademy.carrental.cars;

public class CarDetails {

    private String color;
    private int numberOfDoors;

    public CarDetails(String color, int numberOfDoors) {
        this.color = color;
        this.numberOfDoors = numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
}


