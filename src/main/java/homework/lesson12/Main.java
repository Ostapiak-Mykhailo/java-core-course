package homework.lesson12;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            Validator validator = new Validator();
            EmployeeCreator creator = new EmployeeCreator(validator);
            Employee employee = creator.createEmployee();
            validator.validateFields(employee);
        } catch (NotNullException | ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
