package homework.lesson18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String getInput() throws IOException {
        System.out.println("Enter the numbers you want to be drawn.");
        return reader.readLine();
    }
}
