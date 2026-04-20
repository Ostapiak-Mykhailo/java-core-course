package classwork.lesson5;

import java.util.Comparator;
import java.util.TreeSet;

public class BirdTest {


    public static void main(String[] args) {

        Comparator<Bird> comparator = new BirdColorLengthComparator();
        TreeSet<Bird> birds = new TreeSet<>(comparator);
//        TreeSet<Bird> birds = new TreeSet<>(comparator); - сортування реверсом

        birds.add(new Bird("red"));
        birds.add(new Bird("black"));
        birds.add(new Bird("brown"));
        birds.add(new Bird("yellow"));

        System.out.println(birds);
    }
}
