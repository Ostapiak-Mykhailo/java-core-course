package homework.lesson16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Task1 {

    public static void main(String[] args) {
        String text1 = "i have lost my key";
        String text2 = "";
        String text3 = "Scharnhorst was a German capital ship, alternatively described as a battleship or" +
                " battlecruiser, of Nazi Germany's Kriegsmarine";
        System.out.println(getLongestWord(text1));
        System.out.println(getLongestWord(text2));
        System.out.println(getLongestWord(text3));

    }

    private static Optional<String> getLongestWord(String string) {
        String[] words = string.split("\\W");
        return Arrays.stream(words).max(Comparator.comparing(String::length));

    }
}
