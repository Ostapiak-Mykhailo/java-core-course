package classwork.lesson4;

public class Person {

    public static int PERSON_COUNT = 0;
    int id;
    String name;

    public Person(String name) {
        this.id = ++PERSON_COUNT;
        this.name = name;
    }
}
