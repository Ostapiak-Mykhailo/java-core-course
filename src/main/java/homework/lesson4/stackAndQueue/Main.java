package homework.lesson4.stackAndQueue;

public class Main {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        for (int i = 0; i <= 15; i++) {
            myStack.push(i);
        }
        System.out.println(myStack);

        System.out.println(myStack.pop());
        System.out.println(myStack);

        MyQueue queue = new MyQueue();
        queue.add("TRALALA");
        queue.add("PUPUPU");
        queue.add("PU");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
