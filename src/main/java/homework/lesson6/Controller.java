package homework.lesson6;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Map<Integer, Order> orders = new HashMap<>();

    public void runApp() throws IOException {
        int orderNumber;
        while ((orderNumber = getNumberFromUser()) != 0) {
            if (!isOrderExist(orderNumber)) {
                createOrder(orderNumber);
            } else {
                printStatus(orderNumber);
                OrderStatus status = getOrderStatus();
                changeOrderStatus(orderNumber, status);
            }
        }
    }

    private int getNumberFromUser() throws IOException {
        System.out.println("Please enter the order number to get information or enter `0` to exit the program");
        try {
            String input = reader.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter number only");
            return getNumberFromUser();
        }
    }

    private boolean isOrderExist(int orderNumber) {
        return orders.containsKey(orderNumber);
    }

    private void createOrder(int orderNumber) {
        Order order = new Order(orderNumber);
        orders.put(order.getOrderNumber(), order);
        System.out.println("Order with number " + orderNumber + " was created successfully with status " + order.getStatus());
    }

    private void printStatus(int orderNumber) {
        Order order = orders.get(orderNumber);
        System.out.println(order.getStatus());
        System.out.println("Which status do you want to set for the order?");
    }

    private void changeOrderStatus(int orderNumber, OrderStatus newStatus) {
        Order order = orders.get(orderNumber);
        try {
            if (order.getStatus().ordinal() > newStatus.ordinal()) {
                throw new InvalidStatusException("");
            }
            order.setStatus(newStatus);
            System.out.println("You`ve changed the status of this order " + "\n" + order);
        } catch (InvalidStatusException e) {
            System.out.println("ERROR: It is forbidden to transfer orders from later statuses to earlier ones");
        }
    }

    private OrderStatus getOrderStatus() throws IOException {
        try {
            String input = reader.readLine();
            input = input.toUpperCase();
            return OrderStatus.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input.");
        }
        return getOrderStatus();
    }
}
