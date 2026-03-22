package homework.lesson3.homeTask;

public class Main {

    public static void main(String[] args) {

        MyStrings myStrings = new MyStrings();

        myStrings.add(0, "0");
        myStrings.add(1, "1");
        myStrings.add(2, "2");
        myStrings.add(3, "3");
        myStrings.add(4, "4");
        myStrings.add(5, "5");
        myStrings.add(6, "6");
        myStrings.add(7, "7");
        myStrings.add(8, "8");
        myStrings.add(9, "9");
        myStrings.add(10, "10");
        myStrings.add(11, "11");
        System.out.println(myStrings);

        myStrings.remove(6);
        System.out.println(myStrings);

        myStrings.get(5);
        myStrings.set(0, "TTT");
        System.out.println(myStrings);

    }
}
