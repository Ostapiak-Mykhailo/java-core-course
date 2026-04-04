package homework.lesson4.stackAndQueue;

public class MyStack {

    private Integer[] integers;
    private int size = 0;
    private final int capacity = 10;

    public MyStack() {
        integers = new Integer[capacity];
    }

    public void push(int value) {
        if (capacity <= size) {
            grow();
        }
        integers[size] = value;
        size++;
    }

    public Integer pop() {
        int element = integers[size - 1];
        Integer[] newArray = new Integer[integers.length - 1];
        System.arraycopy(integers, 0, newArray, 0, integers.length - 1);
        integers = newArray;
        size--;
        return element;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                result += "; ";
            }
            result += integers[i];
        }
        result += "]";
        return result;
    }

    private void grow() {
        Integer[] newArray = new Integer[integers.length * 2];
        System.arraycopy(integers, 0, newArray, 0, integers.length);
        integers = newArray;
    }
}
