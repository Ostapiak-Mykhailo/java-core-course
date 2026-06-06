package classwork.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ContainsMain {
    static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        List<String> words = new ArrayList<>();

        fillCollection(words);
        checkCollection(words);

    }

    private static void fillCollection(List<String> words) throws IOException {
        String str;
        while (!(str = READER.readLine()).equals("stop")) {
            words.add(str);
        }
    }

    private static void checkCollection(List<String> words) throws IOException {
        if (words.contains("war")){
            System.out.println("true");
        } else System.out.println("false");

        int count = 0;
        for (String word: words){
            if (word.equals("war")){
                count++;
            }
        }
        System.out.println("The number of forbidden words " + count);
    }
}
