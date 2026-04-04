package classwork.lesson4;

public class A {

    int a;
    int b;

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        return 31 * (31 * a) + b * 29;
    }
}
