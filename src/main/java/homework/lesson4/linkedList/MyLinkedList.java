package homework.lesson4.linkedList;

public class MyLinkedList implements MyLinkedListInterface {

    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    @Override
    public Integer get(int index) {
        isIndex(index);
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public void set(int index, int value) {
        isIndex(index);
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = value;
    }

    @Override
    public void addFirst(int value) {
        Node current = first;
        Node newNode = new Node(value, current, null);
        first = newNode;
        if (size == 0) {
            last = newNode;
        } else {
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public void add(int value) {
        Node current = last;
        Node newNode = new Node(value, null, current);
        last = newNode;
        if (size == 0) {
            first = newNode;
        } else {
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, int value) {
        checkIndex(index);
        Node prev;
        Node current = first;
        Node newNode = new Node(value, null, null);
        if (index == 0) {
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
            }
        } else if (index == size){
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }

        else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            prev = current.prev;
            newNode.prev = prev;
            newNode.next = current;
            prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        isIndex(index);
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (index == 0) {
            first = current.next;
        } else if (index == size - 1) {
            last = current.prev;
        }
        size--;
    }

    private void isIndex(int index) {
        if (0 > index || size <= index) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndex(int index) {
        if (0 > index || size < index) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        String result = "[";
        Node current = first;
        while (current != null){
                result += current.element + ";";
                current = current.next;
        }
        result += "]";
        return result;
    }

    private static class Node {
        Integer element;
        Node next;
        Node prev;

        public Node(Integer element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
