package ro.jademy.carrental;

import ro.jademy.carrental.Cars.Car;
import ro.jademy.carrental.Cars.Dacia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    // Q: what fields and methods should this class contain?
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Salesman> salesmen = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();

    public Shop() {
        Salesman s = new Salesman("Marcel", "aaa");
        salesmen.add(s);
        Dacia logan = new Dacia("Logan", 2018, 2, true, new BigDecimal(25), "white", 90);
        Dacia duster = new Dacia("Duster", 2018, 2, false, new BigDecimal(50), "black", 120);
        Dacia dokker = new Dacia("Dokker", 2018, 2, false, new BigDecimal(40), "white", 100);
        cars.add(logan);
        cars.add(duster);
        cars.add(dokker);
    }

    public boolean login() {
        boolean logedIn = false;
        do {
            System.out.println("Introduceti username : ");
            String user = scanner.next();
            for (Salesman employee : salesmen) {
                if (employee.username.equals(user)) {
                    System.out.println("Introduceti pass : ");
                    String pass = scanner.next();
                    if (employee.password.equals(pass)) {
                        return true;
                    }
                }
            }
        } while (!logedIn);
        System.out.println("Wrong username or password , try again.");
        return false;
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
        System.out.println("5. Check income");
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

    }

    public void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base price of a car based on the number of rental days
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
                System.out.println("Introduceti marca masinii:");
                String make = scanner.nextLine();
                filterByMake(make);
                break;
            case 5:
                logOut();
        }
    }

    public void listAvailableCars() {
        //cred ca trebuie sa fac liste ca sa ramana ce am modificat la rulare
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.println(car.toString());
            }
        }


    }

    public void listRentedCars() {
        //cred ca trebuie sa fac liste ca sa ramana ce am modificat la rulare
        for (Car car : cars) {
            if (car.isRented()) {
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
        }

    }

    public void rentACar() {

        System.out.println("Introdu numarul curent al masinii pe care o inchiriezi :");
        int carRented = scanner.nextInt();
        cars.get(carRented).setRented(true);
    }

    public void wantToReturnACar() {
        System.out.println("Return a Car? Y/N");
        String ans = scanner.nextLine();
        if (ans.equalsIgnoreCase("Y")) {
            returnCar();
        }
        if (ans.equalsIgnoreCase("N")) {
            showMenu();
        }
    }

    public void returnCar() {

        System.out.println("Introdu numarul curent al masinii care s-a intors :");
        int carRented = scanner.nextInt();
        cars.get(carRented).setRented(false);
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
        System.out.println("Filtru dupa marca :" + make);
        for (Car filteredCar : filteredCars) {
            System.out.println(filteredCar.toString());
        }
    }

    public boolean areCarsByMakeAvailable(String make) {
        return filterByMake(make).isEmpty();
    }


    public void filterByModel() {
        System.out.println("Introduceti modelul dupa care doriti sa filtrati lista : ");
        String answer = scanner.nextLine();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(answer)) {
                System.out.println("Filtru dupa model :" + answer);
                System.out.println(cars.toString());
            }
        }
    }

}
