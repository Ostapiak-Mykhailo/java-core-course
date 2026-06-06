package classwork.lesson7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) {

        try (FileInputStream inputStream = new FileInputStream("D:/Test/Test1.txt")) { // додаємо ресурс FileInputStream
            // в параметр конструктора передаємо файл який збираємся копіювати
            File directory = new File("D:/Folder"); // створюємо нову папку Folder
            if (!directory.exists()) { // якщо така папка не існує
                directory.mkdir(); // створимо її
            }
            try (FileOutputStream outputStream = new FileOutputStream("D:/Folder/CopiedFile.txt")) { // додаємо
                // ресурс виводу якому в параметр передаємо новий файл у який буде скопійовано попередній
                byte[] bytes = new byte[inputStream.available()]; // створюємо масив байтів розміром
                // к-стю байтів об'єкта inputStream
                int length;

                while ((length = inputStream.read(bytes)) != -1) { // доки в потоці не закінчаться байти для запису
                    outputStream.write(bytes, 0, length); // передаєм їх в вихідний потік
                }
            } catch (IOException e) {
                System.out.println("Output error " + e.getMessage()); // обробляємо  помилку
            }
        } catch (IOException e) {
            System.out.println("Input error " + e.getMessage());
        }
    }
}
