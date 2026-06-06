package homework.lesson5;

public class Employee {


    private String lastName;
    private String name;
    private int salary;
    private EmployeeType type;

    public Employee(String lastName, String name, int salary, EmployeeType type) {
        this.lastName = lastName;
        this.name = name;
        this.salary = salary;
        this.type = type;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public EmployeeType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", type=" + type +
                '}';
    }
}
