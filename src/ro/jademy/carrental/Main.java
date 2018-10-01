package ro.jademy.carrental;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Q: this is the main entry point of our program. What should we do here?

        Shop shop = new Shop();
        boolean loggedIn = shop.login();
        if (loggedIn) {
            shop.showMenu();
        } else System.out.println("Iesi Acas`");


    }

}
