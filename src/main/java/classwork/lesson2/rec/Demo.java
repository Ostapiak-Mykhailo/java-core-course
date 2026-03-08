package classwork.lesson2.rec;

public class Demo {

    public static void main(String[] args) {
        int start = 5;
        int end = 15;
        printFromStartToEng(start, end); // друк від 5 до 14 без використання циклу
        System.out.println();
        printFromEndToStart(start, end); // друк від 15 до 6 без використання циклу
    }

    private static void printFromStartToEng(int start, int end) {
        if (start < end) {
            System.out.println(start);
            printFromStartToEng(++start, end);
        }
    }

    private static void printFromEndToStart(int start, int end) {
        if (start < end) {
            printFromEndToStart(++start, end);
            System.out.println(start);
        }
    }
}
