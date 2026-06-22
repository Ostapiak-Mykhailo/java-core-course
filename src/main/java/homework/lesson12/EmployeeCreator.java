package homework.lesson12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeCreator {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private final List<Employee> employees = new ArrayList<>();

    public Employee createEmployee() throws IOException {
        String name = getName();
        String email = getEmail();
        String number = getNumber();
        int salary = getSalary();

        Employee employee = new Employee(name, email, number, salary);
        employees.add(employee);
        return employee;
    }

    private String getName() throws IOException {
        System.out.println("Please enter employee`s name");
        String name;
        boolean validName;
        do {
            name = getInput();
            validName = validateName(name);
            if (!validName) {
                System.out.println("Incorrect name. It must start with capital letter and contain 4 letters at least");
            }
        } while (!validName);
        return name;
    }

    private String getEmail() throws IOException {
        System.out.println("Enter employee`s email");
        String email;
        boolean validEmail;
        do {
            email = getInput();
            validEmail = validateEmail(email);
            if (!validEmail) {
                System.out.println("Incorrect input. Please try again");
            }
        } while (!validEmail);
        return email;
    }

    private String getNumber() throws IOException {
        System.out.println("Please enter employee`s number");
        String number;
        boolean validNumber;
        do {
            number = getInput();
            validNumber = validateNumber(number);
            if (!validNumber) {
                System.out.println("Incorrect input. Please try again");
            }
        } while (!validNumber);
        return number;
    }

    private int getSalary() {
        System.out.println("What salary does employee get?");
        int salary;
        boolean validSalary;
        do {
            try {
                salary = Integer.parseInt(getInput());
                validSalary = validateSalary(salary);
                if (!validSalary) {
                    System.out.println("Salary should be in the range of 8500 to 100000");
                }
            } catch (NumberFormatException | IOException e) {
                salary = 0;
                validSalary = false;
                System.out.println(e.getMessage());
            }
        } while (!validSalary);
        return salary;
    }

    private String getInput() throws IOException {
        return READER.readLine();
    }

    private boolean validateName(String name) {
        Pattern pattern = Pattern.compile("[A-Z][a-z]{3,15}");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^([\\w-&&[^а-яА-Я]]{3,})@([\\w-&&[^а-яА-Я]]+)\\.([\\w-&&[^а-яА-Я]]" +
                "{2,})(\\.?([\\w-&&[^а-яА-Я]]{2,}))?$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validateNumber(String number) {
        Pattern pattern = Pattern.compile("^[+]?38(067|068|096|097|098|050|066|075|095|099|063|073|093)\\d{7}$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    private boolean validateSalary(int salary) {
        return salary >= 8500 && salary <= 100000;
    }
}
