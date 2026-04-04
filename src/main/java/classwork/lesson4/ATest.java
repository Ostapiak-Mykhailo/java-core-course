package classwork.lesson4;

public class ATest {

    public static void main(String[] args) {

        A a = new A(2, 3);
        A b = new A(4, 1);
        A c = new A(5, 0);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

    }
}
