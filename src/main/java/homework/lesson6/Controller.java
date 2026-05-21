package homework.lesson6;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Map<Integer, Order> orders = new HashMap<>();

    public Controller() {
    }

//    public void runApp() throws IOException {
//        readOrdersFromFile();
//        int orderNumber;
//        do {
//            orderNumber = getNumberFromUser();
//            if (orderNumber != 0) {
//                if (!isOrderExists(orderNumber)) {
//                    createNewOrder(orderNumber);
//                } else {
//                    printStatus(orderNumber);
//                }
//            }
//        } while (orderNumber != 0);
//        writeOrdersToFile();
//    }

    public void runApp() throws IOException {
        readOrdersFromFile();
        int orderNumber = -1;
        while (orderNumber != 0) {
            orderNumber = getNumberFromUser();
            if (orderNumber == 0) {
                break;
            }
            if (!isOrderExists(orderNumber)) {
                createNewOrder(orderNumber);
            } else {
                printStatus(orderNumber);
            }
        }
        writeOrdersToFile();
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

    private Boolean isOrderExists(int orderNumber) throws IOException {
        return orders.containsKey(orderNumber);
    }

    private void createNewOrder(int orderNumber) throws IOException {
        Order order = new Order(orderNumber, OrderStatus.NEW, LocalDateTime.now());
        orders.put(order.getOrderNumber(), order);
        System.out.println("Order with number " + orderNumber + " was created successfully with status " + order.status);
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

    private void readOrdersFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int orderNumber = Integer.parseInt(parts[0]);
                OrderStatus status = OrderStatus.valueOf(parts[1]);
                LocalDateTime creationDate = LocalDateTime.parse(parts[2]);
                Order order = new Order(orderNumber, status, creationDate);
                orders.put(orderNumber, order);
            }
            if (orders.isEmpty()) {
                System.out.println("The order list is empty yet");
            } else {
                printOrderList();
            }
        } catch (IOException e) {
            System.out.println("Input error " + e.getMessage());
        }
    }

    private void writeOrdersToFile() {
        try (FileWriter writer = new FileWriter("src/Orders.txt")) {
            String line;
            for (Order order : orders.values()) {
                line = "";
                line += order.getOrderNumber();
                line += ";";
                line += order.getStatus();
                line += ";";
                line += order.getCreationDate();
                line += ";";
                line += order.getUpdateDate();
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Output error " + e.getMessage());
        }
    }

    private void printOrderList() {
        System.out.println("Now you can see list of previous orders");
        for (Order order : orders.values()) {
            System.out.println(order.toString());
        }
    }
}
