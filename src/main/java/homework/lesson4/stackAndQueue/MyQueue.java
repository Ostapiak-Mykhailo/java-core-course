package homework.lesson4.stackAndQueue;

public class MyQueue {

    private String[] strings;
    private int size = 0;
    private final int capacity = 10;

    public MyQueue() {
        strings = new String[capacity];
    }

    public void add(String string) {
        if (capacity <= size) {
            grow();
        }
        strings[size] = string;
        size++;
    }

    public String poll() {
        if (size == 0) {
            return null;
        } else {
            String str = strings[0];
            String[] newArray = new String[strings.length - 1];
            System.arraycopy(strings, 1, newArray, 0, strings.length - 1);
            strings = newArray;
            size--;
            return str;
        }
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                result += "; ";
            }
            result += strings[i];
        }
        result += "]";
        return result;
    }

    private void grow() {
        String[] newArray = new String[strings.length * 2];
        System.arraycopy(strings, 0, newArray, 0, strings.length);
        strings = newArray;
    }
}
