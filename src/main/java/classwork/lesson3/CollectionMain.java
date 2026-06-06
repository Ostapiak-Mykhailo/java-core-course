package classwork.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionMain {

    public static void main(String[] args) {


        //create
        int[] numbersArr = new int[5];  // масив
        List<Integer> numbersColl = new ArrayList<>(); // колекція  ArrayList - це по суті обгортка над масивом,
        // що дозволяє легше з ним працювати
        System.out.println("Array - " + Arrays.toString(numbersArr));
        System.out.println("ArrayList - " + numbersColl);

        //get size
        System.out.println("Array length - " + numbersArr.length);
        System.out.println("ArrayList size - " + numbersColl.size());

        //fill array
        numbersArr[0] = 4;
        numbersArr[3] = 14;

        // add to collection (without indexes) - додає новий елемент в кінець колекції
        numbersColl.add(8);
        numbersColl.add(11);
        // {8, 11}
        System.out.println("Array - " + Arrays.toString(numbersArr));
        System.out.println("ArrayList - " + numbersColl);

        // add to collection (with indexes) - додає елемент на вибраний індекс, інші зсуваються вправо
        numbersColl.add(0, 25);
        // {25, 8, 11}
        numbersColl.add(1, 88);
        //{25, 88, 8, 11}
        System.out.println("ArrayList - " + numbersColl);

        // replace value
        numbersColl.set(0, 100);
        // {100, 8, 11}
        System.out.println("ArrayList - " + numbersColl);

        //get element - заміна елемента по індексу
        System.out.println("Element from Array - " + numbersArr[3]);
        System.out.println("Element from ArrayList - " + numbersColl.get(1));

        // in array we can only clear element by index, array length will be the same
        numbersArr[2] = 0;

        //remove
        numbersColl.remove(0);
        System.out.println("ArrayList - " + numbersColl);

        List<String> str = new ArrayList<>();
        str.set(0, "jjj");
    }
}
