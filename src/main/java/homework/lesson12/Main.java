package homework.lesson12;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            EmployeeCreator creator = new EmployeeCreator();
            Validator validator = new Validator();
            Employee employee = creator.createEmployee();
            validator.validateFields(employee);
        } catch (NotNullException e) {
            System.out.println(e.getMessage());
        }
    }
}
