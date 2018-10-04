package ro.jademy.carrental.cars.parts;

public class Engine {

    private double capacity;
    private int horsePower;
    private FuelType fuelType;

    public Engine(double capacity, int horsePower, FuelType fuelType) {
        this.capacity = capacity;
        this.horsePower = horsePower;
        this.fuelType = fuelType;
    }

    public double getCapacity() {
        return capacity;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "capacity=" + capacity +
                ", horsePower=" + horsePower +
                ", fuelType=" + fuelType +
                '}';
    }
}
