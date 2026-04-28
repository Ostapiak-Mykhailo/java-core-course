package homework.lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class EmployeeController {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public EmployeeController() {
    }

    public void fillTreeSet(TreeSet<Employee> employees) throws IOException {
        String lastName = fillEmployeesLastName();
        while (!lastName.equalsIgnoreCase("STOP")) {
            employees.add(createEmployee(lastName));
            lastName = fillEmployeesLastName();
        }
    }

    public Employee createEmployee(String lastName) throws IOException {
        return new Employee(lastName, fillEmployeesName(), fillEmployeesSalary(), chooseEmployeeType());
    }

    public String fillEmployeesName() throws IOException {
        System.out.println("Please enter Employee`s name");
        return READER.readLine();
    }

    private String fillEmployeesLastName() throws IOException {
        System.out.println("Please enter Employee`s last name");
        return READER.readLine();
    }

    private int fillEmployeesSalary() throws IOException {
        int input = 0;
        boolean isChoosen = false;
        while (!isChoosen) {
            try {
                System.out.println("What salary does this employee get?");
                input = Integer.parseInt(READER.readLine());
                if (input < 8600) {
                    throw new IllegalArgumentException("Salary cannot be lower than the minimum wage!");
                }
                isChoosen = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private EmployeeType chooseEmployeeType() throws IOException {
        System.out.println("The final step: choose EmployeeType from the options provided");
        System.out.println(Arrays.toString(EmployeeType.values()));
        while (true) {
            try {
                String input = READER.readLine().toUpperCase();
                return EmployeeType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Please choose from the list");
            }
        }
    }
}
