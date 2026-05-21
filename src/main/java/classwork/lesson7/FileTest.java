package classwork.lesson7;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {

        String path = "D:/Test/Test.txt";
        File file = new File(path);
        System.out.println("File name " + file.getName()); // дізнатися ім'я файлу
        System.out.println("Path " + file.getPath()); // повертає шлях який ми передали в файл
        System.out.println("Absolute path " + file.getAbsolutePath()); // повертає повний шлях від корня диска
        System.out.println("Parent directory " + file.getParent()); // в якій папці знаходиться файл
        System.out.println("File length " + file.length()); // розмір файлу в байтах
        System.out.println("File " + (file.exists() ? "exists" : "doesn`t exist")); // перевірка чи файл існує. Повертає boolean
        System.out.println("File " + (file.canRead() ? "readable" : "not readable")); // перевірка чи можна читати файл
        System.out.println("File " + (file.canWrite() ? "writable" : "not writable")); // перевірка чи можна записувати у файл
        System.out.println(file.isDirectory()); // перевірка чи це папка
        System.out.println(file.isFile()); // перевірка чи це файл
        System.out.println(file.isHidden()); // перевірка чи файл схований
    }
}
