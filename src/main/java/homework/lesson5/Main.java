package homework.lesson5;

import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        Comparator<Employee> comparator = new EmployeeSalaryComparator();
        TreeSet<Employee> employees = new TreeSet<>(comparator);
        EmployeeController controller = new EmployeeController();
        controller.fillTreeSet(employees);

        System.out.println(employees);
    }
}
