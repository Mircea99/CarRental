package ro.jademy.carrental.cars;

import ro.jademy.carrental.cars.parts.Engine;

import java.math.BigDecimal;

public abstract class Car {

    protected String make;
    protected String model;
    protected Integer year;
    protected Engine engine;
    protected CarDetails details;
    protected BigDecimal basePrice;

    protected CarState state = new CarState();

    public Car(String make, String model, Integer year, Engine engine, CarDetails details, BigDecimal basePrice, boolean isRented) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.details = details;
        this.basePrice = basePrice;
        this.state.setRented(isRented);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }

    public CarDetails getDetails() {
        return details;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public CarState getState() {
        return state;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engine=" + engine +
                ", details=" + details +
                ", basePrice=" + basePrice +
                ", state=" + state +
                '}';
    }
}
