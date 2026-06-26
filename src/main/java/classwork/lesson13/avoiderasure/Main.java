package classwork.lesson13.avoiderasure;

import java.lang.reflect.InvocationTargetException;

public class Main {
    // створення об'єкту Т в обхід стирання типів
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Test<MySecretClass> test = new Test<>(MySecretClass.class);
        MySecretClass mySecretClass = test.createNewT();
    }
}
