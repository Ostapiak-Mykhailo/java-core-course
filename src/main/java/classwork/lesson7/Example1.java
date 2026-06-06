package classwork.lesson7;

import java.io.*;

public class Example1 {

    public static void main(String[] args) {

        readFile();
        writeFile();
        readFile();
    }

    private static void writeFile() { // метод для запису файлу
        try (PrintWriter pw = new PrintWriter("newFile.txt")) { // створюємо файл, якщо вже існує - перезаписуєм
            pw.println("everything is working"); // записуєм строки у файл
            pw.println("Hello world"); // записуєм строки у файл
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void readFile() { //метод для читання файлу
        try (BufferedReader reader = new BufferedReader(new FileReader("newFile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) { // читаємо строки поки вони є. Коли строки закінчаться - вихід з циклу
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
