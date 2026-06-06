package classwork.lesson8;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {

        Student student = new Student(18, "Pupkin", "Vasia");

        try {
            // створюємо потік для запису байтів у файл student.txt
            FileOutputStream outputStream = new FileOutputStream("student.txt");
            // створюємо потік для серіалізації об'єктів поверх FileOutputStream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            // записуємо об'єкт student у файл
            objectOutputStream.writeObject(student); //
            // примусово записуємо буфер у файл
            objectOutputStream.flush();
            // закриваємо потік (разом із FileOutputStream)
            objectOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        // те саме через try with resources
//        try (ObjectOutputStream objectOutputStream =
//                     new ObjectOutputStream(new FileOutputStream("student.txt"))) {
//
//            objectOutputStream.writeObject(student);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
