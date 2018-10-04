package ro.jademy.carrental;


import ro.jademy.carrental.cars.Car;
import ro.jademy.carrental.cars.CarDetails;
import ro.jademy.carrental.cars.Dacia;
import ro.jademy.carrental.cars.parts.Engine;
import ro.jademy.carrental.cars.parts.FuelType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Salesman> salesmen = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();

    public Shop() {

        Engine dieselEngine = new Engine(1.9, 135, FuelType.DIESEL);
        Engine gasolineEngine = new Engine(1.6, 115, FuelType.GASOLINE);
        CarDetails carDetails1 = new CarDetails("Black", 4);
        CarDetails carDetails2 = new CarDetails("White", 4);

        Salesman s = new Salesman("Marcel", "aaa");
        salesmen.add(s);
        Dacia logan = new Dacia("Logan", 2018, dieselEngine, carDetails1, new BigDecimal(30), true);
        Dacia duster = new Dacia("Duster", 2018, gasolineEngine, carDetails2, new BigDecimal(70), false);
        Dacia dokker = new Dacia("Dokker", 2018, dieselEngine, carDetails1, new BigDecimal(50), false);
        cars.add(logan);
        cars.add(duster);
        cars.add(dokker);
    }

    public boolean login() {

        System.out.println("Introduceti username : ");
        String user = scanner.next();
        System.out.println("Introduceti pass : ");
        String pass = scanner.next();
        for (Salesman employee : salesmen) {
            if (employee.getUsername().equals(user) && employee.getPassword().equals(pass)) {
                return true;
            }
        }
        System.out.println("Wrong username or password , try again.");
        return login();
    }

    public void logOut() {

        System.out.println("Are you sure you want to log out? Y/N");
        String ans = scanner.nextLine();
        if (ans.equalsIgnoreCase("Y")) {
            login();
        } else showMenu();

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
        System.out.println("5. Filter by ");
        System.out.println("6. Logout");
        System.out.println("7. Exit");

        readMenuAnswer();
    }

    public void readMenuAnswer() {
        System.out.println("Please input your answer");
        int answer = scanner.nextInt();

        menuChoice(answer);
    }


    public void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        // TODO: add additional filter methods based on car specs

        System.out.println("4. Back to previous menu");

        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                System.out.println("Please enter car make:");
                String make = scanner.next();
                printByMake(make);
                showPrevoiusMenu();
                break;
            case 2:
                System.out.println("Please enter car model:");
                String model = scanner.next();
                printByModel(model);
                showPrevoiusMenu();
        }

    }

    public void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base basePrice of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays scanner which the discount should be smaller

        // Q: what should be the return type of this method?
    }

    public void listAllCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }


    public void menuChoice(int i) {

        switch (i) {
            case 1:
                listAllCars();
                wantToRentACar();
                break;
            case 2:
                listAvailableCars();
                wantToRentACar();
                break;
            case 3:
                listRentedCars();
                wantToReturnACar();
                break;

            case 4:

                break;
            case 5:
                logOut();
                break;

            case 6:
                showListMenuOptions();


                break;
        }
    }

    public void listAvailableCars() {
        for (Car car : cars) {
            if (!car.getState().isRented()) {
                System.out.println(car.toString());
            }
        }

    }

    public void listRentedCars() {
        for (Car car : cars) {
            if (car.getState().isRented()) {
                System.out.println(car.toString());
            }
        }
    }

    public void wantToRentACar() {
        System.out.println("Rent a Car? Y/N");
        String ans = scanner.next();
        if (ans.equalsIgnoreCase("N")) {
            showMenu();
        }
        if (ans.equalsIgnoreCase("Y")) {
            rentACar();
            showPrevoiusMenu();
        }

    }

    public void rentACar() {

        System.out.println("Introdu numarul curent al masinii pe care o inchiriezi :");
        int carRented = scanner.nextInt();
        cars.get(carRented).getState().setRented(true);
    }

    public void wantToReturnACar() {
        System.out.println("Return a Car? Y/N");
        String ans = scanner.next();
        if (ans.equalsIgnoreCase("N")) {
            showMenu();
        }
        if (ans.equalsIgnoreCase("Y")) {
            returnCar();
            showPrevoiusMenu();
        }
    }

    public void returnCar() {

        System.out.println("Introdu numarul curent al masinii care s-a intors :");
        int carRented = scanner.nextInt();
        cars.get(carRented).getState().setRented(false);
    }

    public List<Car> filterByMake(String make) {

        ArrayList<Car> filteredByMake = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                filteredByMake.add(car);
            }
        }

        return filteredByMake;
    }

    public void printByMake(String make) {

        List<Car> filteredCars = filterByMake(make);

        if (filteredCars.isEmpty()) {
            System.out.println("No car available by make: " + make);
        } else {
            for (Car filteredCar : filteredCars) {
                System.out.println(filteredCar.toString());
            }
        }
    }


    public List<Car> filterByModel(String model) {
        ArrayList<Car> filteredByModel = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                filteredByModel.add(car);
            }
        }
        return filteredByModel;
    }

    public void printByModel(String model){

        List<Car> filteredCars = filterByModel(model);

        if (filteredCars.isEmpty()) {
            System.out.println("No car available by make: " + model);
        } else {
            for (Car filteredCar : filteredCars) {
                System.out.println(filteredCar.toString());
            }
        }
    }


    public void showPrevoiusMenu(){
        System.out.println(" ");
        System.out.println("2. Back to previous menu ? Press 2.");
        int ans = scanner.nextInt();
        if(ans == 2){
            showMenu();
        }
    }

}
