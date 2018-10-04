package ro.jademy.carrental.cars;

import ro.jademy.carrental.cars.parts.Engine;

import java.math.BigDecimal;

public class Dacia extends Car {

    public Dacia(String model, Integer year, Engine engine, CarDetails details, BigDecimal basePrice, boolean isRented) {
        super("Dacia", model, year, engine, details, basePrice, isRented);
    }
}




