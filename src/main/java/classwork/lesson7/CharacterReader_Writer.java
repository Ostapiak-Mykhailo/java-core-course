package classwork.lesson7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CharacterReader_Writer {

    public static void main(String[] args) {

        writeFileByCharacterStream();
        readFileByCharacterStream();

    }

    private static void writeFileByCharacterStream() {
        String text = "TRALALA"; // текст який записуємо в файл

        try (PrintWriter writer = new PrintWriter("D:/Folder/Test2.txt")) { // додаємо ресурс PrintWriter
            // в конструктор передаємо шлях до файлу
            writer.write(text); // записуємо текст у файл
        } catch (IOException e) { // обробляємо можливу помилку
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void readFileByCharacterStream() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:/Folder/Test2.txt"))) { // додаємо ресурс
            // BufferedReader для читання файлу
            int symbol;
            while ((symbol = reader.read()) != -1) { // читаємо символи, доки не дійдемо до кінця файлу
                System.out.print((char) symbol); // виводимо в консоль
            }
        } catch (IOException e) { // не забуваєм можливі помилки
            System.out.println("Error " + e.getMessage());
        }
    }
}
