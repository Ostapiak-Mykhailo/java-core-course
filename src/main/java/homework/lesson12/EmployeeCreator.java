package homework.lesson12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeCreator {

    private final ConsoleReader reader = new ConsoleReader();
    private final Validator validator;
    private final List<Employee> employees = new ArrayList<>();

    public EmployeeCreator(Validator validator) {
        this.validator = validator;
    }

    public Employee createEmployee() throws IOException {

        String name = getValidInput("Please enter employee`s name or enter `0` to omit this step", true);
        if (name != null) {
            validator.validateName(name);
        }

        String email = getValidInput("Enter employee`s email or enter `0` to omit this step", true);
        if (email != null) {
            validator.validateEmail(email);
        }

        String number = getValidInput("Please enter employee`s number", false);
        validator.validateNumber(number);

        int salary = Integer.parseInt(Objects.requireNonNull(getValidInput("What salary does employee get?", false)));
        validator.validateSalary(salary);

        Employee employee = new Employee(name, email, number, salary);
        employees.add(employee);
        return employee;
    }

    private String getValidInput(String message, boolean allowNull) throws IOException {
        System.out.println(message);
        String input = reader.getInput();
        if (allowNull && "0".equals(input)) {
            input = null;
        }
        return input;
    }
}
