package classwork.lesson8;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Book implements Externalizable {

    private int year;
    private String author;
    private String genre;

    // обов'язковий public конструктор без параметрів
    public Book() {
    }

    public Book(int year, String author, String genre) {
        this.year = year;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        // записуємо тільки автора і жанр
        out.writeUTF(author);
        out.writeUTF(genre);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        // читаємо в тому самому порядку
        author = in.readUTF();
        genre = in.readUTF();
    }

    @Override
    public String toString() {
        return "Book{" +
                "year=" + year +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
