package classwork.lesson4;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {

        // Linked list
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i < 21; i++) {
            numbers.add(i);
        }
        System.out.println("LinkedList - " + numbers);
        numbers.add(200);
        numbers.get(5);
        numbers.remove(3);
        numbers.set(0, 35);
        numbers.add(10, 200);
        numbers.toString();
        System.out.println(numbers);

        // stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack - " + stack);
        System.out.println(stack.peek()); // Метод peek показує верхушку стеку
        System.out.println(stack);

        System.out.println(stack.pop()); // Метод pop повертає верхушку стеку, і видаляє її
        System.out.println(stack);

        Queue<String> queue = new PriorityQueue<>();
        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.add("Four");
        System.out.println(queue);// для строк дефолтний пріоритет - по алфавіту

        System.out.println(queue.peek());

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add("One");
        deque.add("Two");
        deque.add("Three");
        deque.add("Four");

        System.out.println(deque);
        System.out.println(deque.poll());
        System.out.println(deque);

        Map<String, Integer> map = new HashMap<>();// ключ (key) — типу String, значення (value) — типу Integer
        map.put("apples", 5);
        map.put("tomatoes", 10);

        System.out.println(map);

        System.out.println(map.get("apples"));
        System.out.println(map.get("invalid"));

        System.out.println(map.containsKey("tomatoes"));
        System.out.println(map.containsKey("test"));

        for (Map.Entry<String, Integer> entry : map.entrySet()) { // ітерація по мапі
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue() == 5) {
                map.remove(entry.getKey()); // видалення по значенню
            }
        }
        System.out.println(map);

        map.remove("apples");// видалення по ключу
        System.out.println(map);

        Set<String> keys = map.keySet(); // отримати всі ключі
        System.out.println("KEYS " + keys);

        Collection<Integer> values = map.values(); // отримати всі значення
        System.out.println("VALUES " + values);

    }

}
