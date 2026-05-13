package classwork.lesson6;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ErrorHandling {

    public static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        int line = readNumber(1, 5);
        System.out.println(line);
    }

    public static String readLine() {
        System.out.println("input string");
        try {
            return READER.readLine();
        } catch (IOException e) {
            System.out.println("ERROR " + e.getMessage());
            return readLine();
        }
    }

    public static int readNumber() {
        System.out.println("input number");
        try {
            return Integer.parseInt(READER.readLine());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
            return readNumber();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }

    public static int readNumber(int min, int max) {
        System.out.println("input number");
        try {
            int number = Integer.parseInt(READER.readLine());
            if (number < min || number > max){
                throw new NumberNotInRangeException("number is incorrect");
            }
            return number;
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
            return readNumber(min, max);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        } finally {
            System.out.println("FINALLY");
        }
    }
}
