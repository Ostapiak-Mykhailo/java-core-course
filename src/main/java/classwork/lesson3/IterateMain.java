package classwork.lesson3;

import java.util.ArrayList;
import java.util.List;

public class IterateMain {

    public static void main(String[] args) {


        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        for (int i = 0; i < numbers.size(); i++) { // вивід елементів в зворотньому порядку
            int j = numbers.size() - i - 1;
            System.out.print(numbers.get(j) + " ");
        }
        System.out.println();

        for (Integer number: numbers){
            System.out.println(number);
        }

        System.out.println("does 7 exist in this coll - " + numbers.contains(7));
        System.out.println("does 15 exist in this coll - " + numbers.contains(15));
    }
}
