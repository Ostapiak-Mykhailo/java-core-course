package homework.lesson1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Restaurant restaurant = new Restaurant();
        greetCustomer();
        restaurant.bookTable();
    }

    private static void greetCustomer() {
        System.out.println("Hello to my restaurant");
    }
}
