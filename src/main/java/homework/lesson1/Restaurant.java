package homework.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Restaurant {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public void bookTable() throws IOException {
        String suggestion = """
                Please choose table you want to book
                You have 3 options: Table1, Table2 or Table3
                """;
        System.out.println(suggestion);
        while (true) {
            String str = READER.readLine();
            str = str.toUpperCase();
            try {
                TableChoice.valueOf(str);
                System.out.println("You have booked " + str + " successfully");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice");
            }
        }
    }
}
