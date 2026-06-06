package classwork.lesson7;

import java.io.*;

public class ByteReader_Writer {

    public static void main(String[] args) {

        writeFileByBytes();
        readFileByBytes();

    }

    public static void writeFileByBytes() {
        String text = "Hello WORLD"; // текст який будем записувати в файл
        byte[] bytes = text.getBytes(); // переводим текст в масив байтів

        try (OutputStream stream = new FileOutputStream("D:/Test/Test1.txt")) { // додаємо ресурс OutputStream
            for (byte eachByte : bytes) { // в циклі виконуємо побайтовий запис з масиву байтів в файл
                stream.write(eachByte);
            }
        } catch (IOException e) { // обробляємо помилку
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void readFileByBytes() {
        try (FileInputStream stream = new FileInputStream("D:/Test/Test1.txt")) { // додаємо ресурс FileInputStream
            // в параметр конструктора передаємо шлях до файлу
            int symbol;

            while ((symbol = stream.read()) != -1) { // в циклі допоки в потоці не закінчаться символи
                System.out.print((char) symbol); // виводимо символи приведені до типу char
            }
        } catch (IOException e) { // обробляєм помилку
            System.out.println("Error " + e.getMessage());
        }
    }
}
