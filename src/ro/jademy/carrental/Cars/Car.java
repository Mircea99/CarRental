package ro.jademy.carrental.Cars;

import java.math.BigDecimal;

public abstract class Car {
    public String make;
    public String model;
    public Integer year;
    public float engine;
    public boolean isRented;
    public BigDecimal price;
    public String color;
    public int horsePower;

    public Car(String make, String model, Integer year, float engine, boolean isRented, BigDecimal price, String color, int horsePower) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.isRented = isRented;
        this.price = price;
        this.color = color;
        this.horsePower = horsePower;
    }



    public String getColor() {
        return color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRented() {
        return this.isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(float engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engine=" + engine +
                ", isRented=" + isRented +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", horsePower=" + horsePower +
                '}';
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    //abstract class
    //move to new class

    // Q: how can we better represent the car make?


    // Q: how can we better represent the car type?
//        public String carType; // coupe, sedan, hatchback, convertible, wagon, SUV
//
//        // Q: how can we better represent the motor type?
//        public String fuelType; // diesel, gasoline, alternative
//
//        public int doorNumber;
//
//        public String color;
//
//        // Q: how can we better represent the transmission type?
//        public String transmissionType; // automatic, manual
//
//        // Q: how can we better represent the engine?
//        public double engine;
//
//        // Q: how can we better represent money value?
//        public float basePrice;
//
//        // Q: do we need a constructor other than the default one?
//        // Q: how can we better protect the car data?
}
