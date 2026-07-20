package classwork.lesson15.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) throws IOException {

        String text = Files.readString(Path.of("src/main/java/classwork/lesson15/resources/news.txt"));

        String[] words = text.split("\\W+");
        List<String> longWords = new ArrayList<>();
        int count = 0;

        for (String word: words){
            if (word.length() >= 12){
                longWords.add(word);
                count++;
            }
        }
        System.out.println("LONG WORDS: " + longWords);
        System.out.println("amount of long words: " + count);
    }
}
