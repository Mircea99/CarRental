package ro.jademy.carrental;

import ro.jademy.carrental.Cars.Car;
import ro.jademy.carrental.Cars.Dacia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    // Q: what fields and methods should this class contain?

    private ArrayList<Salesman> salesmen = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();

    public Shop() {
        Salesman s = new Salesman("Marcel", "aaa");
        salesmen.add(s);
        Dacia logan = new Dacia("Logan", 2018, 2, false, new BigDecimal(25), 90);
        cars.add(logan);
    }

    public boolean login() {
        boolean logedIn = false;
        do {
            System.out.println("Introduceti username : ");
            Scanner in = new Scanner(System.in);
            String user = in.next();
            for (Salesman employee : salesmen) {
                if (employee.username.equals(user)) {
                    System.out.println("Introduceti pass : ");
                    String pass = in.next();
                    if (employee.password.equals(pass)) {
                        return true;
                    }
                }
            }
        } while (!logedIn);
        System.out.println("Wrong username or password , try again.");
        return false;
    }


    public void showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Jademy Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. Check income");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
    }

    public void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        // TODO: add additional filter methods based on car specs

        System.out.println("4. Back to previous menu");

    }

    public void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base price of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays in which the discount should be smaller

        // Q: what should be the return type of this method?
    }

    public void listAllCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }


    public void menuChoice(int i) {

        System.out.println("param= " + i);
        switch (i) {
            case 1:
                listAllCars();
                break;
            case 2:
        }


    }

    public void listAvailableCars() {


    }
}
