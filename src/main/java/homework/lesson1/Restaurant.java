package homework.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final List<Table> tables;
    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public Restaurant(int numberOfTables) {
        this.tables = new ArrayList<>();
        for (int i = 1; i <= numberOfTables; i++) {
            Table table = new Table(i);
            tables.add(table);
        }
    }

    public void runMenu() throws IOException {
        while (true) {
            OptionChoice optionChoice = getInputFromUser();
            switch (optionChoice) {
                case BOOK -> bookTable();
                case LEAVE -> leaveTable();
                default -> System.out.println("You have these two options only");
            }
        }
    }

    public OptionChoice getInputFromUser() throws IOException {
        System.out.println("Please choose what do you want to do: to BOOK table or to LEAVE it");
        while (true) {
            String input = READER.readLine();
            input = input.toUpperCase();
            try {
                return OptionChoice.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Please choose one from the options provided");
            }
        }
    }

    public void bookTable() throws IOException {
        System.out.println("Now you can see the numbers of unbooked tables. " +
                "Please enter the number of table you want to book");
        for (Table table : tables) {
            if (!table.isBooked()) {
                System.out.println(table.getNumber());
            }
        }
        while (true) {
            String input = READER.readLine();
            int number;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Please enter the number only");
                continue;
            }
            if (number < 1 || number > tables.size()) {
                System.out.println("There is no table with this number.");
            } else if (tables.get(number - 1).isBooked()) {
                System.out.println("Sorry, this table has already been booked. Please choose another one");
            } else {
                tables.get(number - 1).setBooked(true);
                System.out.println("You have booked table " + number + " successfully");
                break;
            }
        }
    }

    public void leaveTable() throws IOException {
        System.out.println("Now you can see the numbers of tables which are booked. " +
                "Please enter the number of table you want to leave");
        for (Table table : tables) {
            if (table.isBooked()) {
                System.out.println(table.getNumber());
            }
        }
        while (true){
            String input = READER.readLine();
            int number;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Just enter a number");
                continue;
            }
            if (number < 1 || number > tables.size()){
                System.out.println("There is no table with this number.");
            } else if (!tables.get(number - 1).isBooked()){
                System.out.println("You cannot leave table if you haven`t booked it:)");
            } else {
                tables.get(number - 1).setBooked(false);
                System.out.println("You have left table " + number + " successfully");
                break;
            }
        }
    }
}
