package homework.lesson4.linkedList;

public interface MyLinkedListInterface {

    Integer get(int index);

    void set(int index, int value);

    void remove(int index);

    void addFirst(int value);

    void add(int value);

    void add(int index, int value);

    String toString();
}
