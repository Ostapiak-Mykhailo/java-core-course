package classwork.lesson13.avoiderasure;

import java.lang.reflect.InvocationTargetException;

public class Test <T> {

    Class<T> typeParametrClass;

    public Test(Class<T> typeParametrClass) {
        this.typeParametrClass = typeParametrClass;
    }

    public T createNewT() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        T t = typeParametrClass.getDeclaredConstructor().newInstance();
        return t;
    }
}
