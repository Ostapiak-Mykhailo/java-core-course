package homework.lesson3.homeTask;


public class MyStrings implements MyArrayListInterface {

    private String[] strings;
    private int size = 0;
    private static final int capacity = 10;

    public MyStrings() {
        strings = new String[capacity];
    }

    @Override
    public void set(int index, String string) {
        if (index >= 0 && index <= strings.length - 1) {
            strings[index] = string;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void get(int index) {
        if (index >= 0 && index <= strings.length - 1) {
            System.out.println(strings[index]);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i == size; i++) {
            strings[i] = strings[i + 1];
            size--;
        }
    }


    @Override
    public void add(int index, String string) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= capacity) {
            grow();
        }
        for (int i = size; i > index; i--) {
            strings[i] = strings[i - 1];
        }
        strings[index] = string;
        size++;
    }

    private void grow() {
        String[] newArray = new String[strings.length * 2];
        System.arraycopy(strings, 0, newArray, 0, strings.length);
        strings = newArray;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += strings[i] + "; ";
        }
        result += "]";
        return result;
    }
}
