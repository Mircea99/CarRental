package ro.jademy.carrental;

import ro.jademy.carrental.Cars.Car;
import ro.jademy.carrental.Cars.Dacia;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Main {

    public static void main(String[] args) {
        // Q: this is the main entry point of our program. What should we do here?

        Shop shop = new Shop();
        boolean loggedIn = shop.login();
        if (loggedIn) {
            shop.showMenu();
        } else System.out.println("Iesi Acas`");

        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        shop.menuChoice(answer);


    }

}
