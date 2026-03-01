package homework.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Restaurant {

    private final List<Table> tables;
    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public Restaurant(List<Table> tables) {
        this.tables = tables;
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
    }

    public void doOption() throws IOException {
        while (true) {
            OptionChoice optionChoice = suggestOption();
            switch (optionChoice) {
                case BOOK -> bookTable();
                case LEAVE -> leaveTable();
                default -> System.out.println("You have these two options only");
            }
        }
    }

    public OptionChoice suggestOption() throws IOException {
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
        TableChoice tableChoice = suggestToBookTable();
        switch (tableChoice) {
            case TABLE1 -> {
                tables.getFirst().setBooked(true);
                System.out.println("You have booked table 1 successfully");
            }
            case TABLE2 -> {
                tables.get(1).setBooked(true);
                System.out.println("You have booked table 2 successfully");
            }
            case TABLE3 -> {
                tables.get(2).setBooked(true);
                System.out.println("You have booked table 3 successfully");
            }
        }
    }

    public void leaveTable() throws IOException {
        TableChoice tableChoice = suggestToLeaveTable();
        switch (tableChoice) {
            case TABLE1 -> {
                tables.getFirst().setBooked(false);
                System.out.println("You have left table 1");
            }
            case TABLE2 -> {
                tables.get(1).setBooked(false);
                System.out.println("You have left table 2");
            }
            case TABLE3 -> {
                tables.get(2).setBooked(false);
                System.out.println("You have left table 3");
            }
        }
    }

    public TableChoice suggestToBookTable() throws IOException {
        System.out.println("Please choose table you want to book");
        System.out.println("You can book following tables:");
        for (Table table : tables) {
            if (!table.isBooked())
                try {
                    System.out.println(table);
                } catch (IllegalArgumentException e) {
                    System.out.println("invalid choice");
                }
        }
        String input = READER.readLine();
        input = input.toUpperCase();
        return TableChoice.valueOf(input);
    }

    public TableChoice suggestToLeaveTable() throws IOException {
        System.out.println("Please choose table you want to leave");
        for (Table table : tables) {
            if (table.isBooked())
                try {
                    System.out.println(table);
                } catch (IllegalArgumentException e) {
                    System.out.println("invalid choice");
                }
        }
        String input = READER.readLine();
        input = input.toUpperCase();
        return TableChoice.valueOf(input);
    }
}
