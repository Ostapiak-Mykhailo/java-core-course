package classwork.lesson8;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationDemo {

    public static void main(String[] args) {

        try {
            // створюємо потік для читання байтів із файлу student.txt
            FileInputStream fileInputStream = new FileInputStream("student.txt");
            // створюємо потік для десеріалізації об'єктів
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // читаємо об'єкт із файлу та приводимо його до типу Student
            // readObject() повертає Object, тому потрібен каст
            Student student = (Student) objectInputStream.readObject();
            // виводимо об'єкт у консоль
            System.out.println(student.toString());
            // закриваємо потік (разом із FileInputStream)
            objectInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        // те саме через try with resources
//        try (ObjectInputStream objectInputStream =
//                     new ObjectInputStream(new FileInputStream("student.txt"))) {
//            Student student = (Student) objectInputStream.readObject();
//            System.out.println(student);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
