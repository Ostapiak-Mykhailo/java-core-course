package homework.lesson12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCreator {

    private final ConsoleReader reader = new ConsoleReader();
    private final Validator validator;
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeCreator(Validator validator) {
        this.validator = validator;
    }

    public Employee createEmployee() throws IOException {

        System.out.println("Please enter employee`s name or enter `0` to omit this step");
        String name = reader.getInput();
        if ("0".equals(name)) {
            name = null;
        } else {
            validator.validateName(name);
        }

        System.out.println("Enter employee`s email or enter `0` to omit this step");
        String email = reader.getInput();
        if ("0".equals(email)) {
            email = null;
        } else {
            validator.validateEmail(email);
        }

        System.out.println("Please enter employee`s number");
        String number = reader.getInput();
        validator.validateNumber(number);

        System.out.println("What salary does employee get?");
        int salary;
        try {
            salary = Integer.parseInt(reader.getInput());
        } catch (NumberFormatException e) {
            throw new ValidationException("This field must be a number");
        }

        Employee employee = new Employee(name, email, number, salary);
        employees.add(employee);
        return employee;
    }
}
