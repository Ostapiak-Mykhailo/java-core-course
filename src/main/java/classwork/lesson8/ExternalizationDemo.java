package classwork.lesson8;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ExternalizationDemo {

    public static void main(String[] args) {

        Book book = new Book(1999, "Stephen King", "Horror");

        // екстерналізація
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("book.txt"))) {
            outputStream.writeObject(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
