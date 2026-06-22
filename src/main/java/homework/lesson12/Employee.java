package homework.lesson12;

public class Employee {

    @NotNullValue
    private String name;
    @NotNullValue
    private String email;
    private String number;
    private int salary;

    public Employee(String name, String email, String number, int salary) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.salary = salary;
    }
}
