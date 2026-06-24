package homework.lesson12;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Validator {

    public void validateFields(Employee employee) throws ClassNotFoundException {

        try {
            Class<?> cl = Class.forName("homework.lesson12.Employee");
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNullValue.class)) {
                    if (field.get(employee) == null) {
                        throw new NotNullException(field.getName());
                    } else {
                        System.out.println("Field " + field.getName().toUpperCase() + " is annotated with " +
                                Arrays.toString(field.getAnnotations()) + " and it is valid");
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
