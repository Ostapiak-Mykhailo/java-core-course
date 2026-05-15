package homework.lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Map<Integer, Order> orders = new HashMap<>();

    public Controller() {
    }

    public void runApp() throws IOException {
        while (true) {
            int orderNumber = getNumberFromUser();
            if (!isOrderExists(orderNumber)) {
                createNewOrder(orderNumber);
            } else {
                printStatus(orderNumber);
            }
        }
    }

    private int getNumberFromUser() throws IOException {
        System.out.println("Please enter the order number to get information");
        try {
            String input = reader.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter number only");
            return getNumberFromUser();
        }
    }

    private Boolean isOrderExists(int orderNumber) throws IOException {
        return orders.containsKey(orderNumber);
    }

    private void createNewOrder(int orderNumber) throws IOException {
        Order order1 = new Order(orderNumber, OrderStatus.NEW, LocalDateTime.now());
        orders.put(order1.getOrderNumber(), order1);
        System.out.println("Order with number " + orderNumber + " was created successfully with status " + order1.status);
    }

    private void printStatus(int orderNumber) throws IOException {
        Order order = orders.get(orderNumber);
        System.out.println(order.getStatus());
        System.out.println("Which status do you want to set for the order?");
        changeOrderStatus(orderNumber);
    }

    private void changeOrderStatus(int orderNumber) throws IOException {
        Order order = orders.get(orderNumber);
        try {
            OrderStatus newStatus = getOrderStatus();
            if (order.getStatus().ordinal() > newStatus.ordinal()) {
                throw new InvalidStatusException("");
            }
            order.setStatus(newStatus);
            order.setUpdateDate(LocalDateTime.now());
            System.out.println(order);
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
