package classwork.lesson5;

import java.util.Comparator;

public class BirdColorLengthComparator implements Comparator<Bird> {

    @Override
    public int compare(Bird o1, Bird o2) {
        return o1.getColor().length() - o2.getColor().length(); // відсортує по довжині назви кольору
    }
}
