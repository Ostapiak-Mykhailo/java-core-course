package classwork.lesson15.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo11 {

    public static void main(String[] args) throws IOException {

        String text = Files.readString(Path.of("src/main/java/classwork/lesson15/resources/news.txt"));

        String[] words = text.split("\\PL+");
        List<String> longWords = new ArrayList<>();

        // створюєм стрім
        longWords = Arrays.stream(words)
                // фільтруємо довгі слова
                .filter(word -> word.length() >= 12)
                // збираєм назад у список
                .toList();

        System.out.println("LONG WORDS: " + longWords);
        System.out.println("amount: " + longWords.size());
    }
}
