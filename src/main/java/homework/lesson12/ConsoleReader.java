package homework.lesson12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String getInput() throws IOException {
        return reader.readLine();
    }
}
