package classwork.lesson6;

import java.util.Arrays;

public class StackTraceTest {

    public static void main(String[] args) {

        method1();

    }

    public static void method1() {
        System.out.println("method1 " + Arrays.toString(Thread.currentThread().getStackTrace()));
        method2();
    }

    public static void method2() {
        System.out.println("method2 " + Arrays.toString(Thread.currentThread().getStackTrace()));
        method3();
    }

    public static void method3() {
        System.out.println("method3 " + Arrays.toString(Thread.currentThread().getStackTrace()));
        method4();
    }

    public static void method4() {
        System.out.println("method4 " + Arrays.toString(Thread.currentThread().getStackTrace()));
        try {
            System.out.println("before call method5");
            method5();
            System.out.println("after call method5");
        } catch (Exception exception){
            System.out.println("ERROR " + exception.getMessage());
        }

        System.out.println("After method5");
    }

    public static void method5() {
        System.out.println("method5 " + Arrays.toString(Thread.currentThread().getStackTrace()));

        int[] array = new int[5];
        System.out.println(array[6]);

        System.out.println("After array");
    }
}
