package classwork.lesson8;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeexternalisationDemo {

    public static void main(String[] args) {

        // деекстерналізація
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("book.txt"))) {
            Book restoredBook = (Book) inputStream.readObject();
            System.out.println(restoredBook);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
