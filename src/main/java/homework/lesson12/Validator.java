package homework.lesson12;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public void validateFields(Employee employee) {

        try {
            Field[] fields = employee.getClass().getDeclaredFields();
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
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    void validateName(String name) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,15}");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect name. It must start with capital letter and contain 4–16 letters");
        }
    }

    void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^([\\w-&&[^а-яА-Я]]{3,})@([\\w-&&[^а-яА-Я]]+)\\.([\\w-&&[^а-яА-Я]]" +
                "{2,})(\\.?([\\w-&&[^а-яА-Я]]{2,}))?$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect input. Please try again");
        }
    }

    void validateNumber(String number) {
        Pattern pattern = Pattern.compile("^[+]?38(067|068|096|097|098|050|066|075|095|099|063|073|093)\\d{7}$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect input. Please please enter Ukrainian number");
        }
    }

    void validateSalary(int salary) {
        if (salary < 8500 || salary > 100000) {
            throw new ValidationException("Salary must be between 8_500 and 100_000 UAH");
        }
    }
}
