package homework.lesson3.additionalTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopView {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public ShopView() {
    }

    public void greetCustomer() throws IOException {
        String greeting = """
                Hello to my shop. There are three departments: Household, Hygiene and Food.
                """;
        System.out.println(greeting);
    }

    public DepartmentType selectDepartment() throws IOException {
        boolean isChosen = false;
        DepartmentType departmentType = null;
        while (!isChosen) {
            String input = getInput();
            input = input.toUpperCase();
            try {
                departmentType = DepartmentType.valueOf(input);
                isChosen = true;
            } catch (IllegalArgumentException e) {
                System.out.println("I haven`t opened such department... Yet");
            }
        }
        return departmentType;
    }

    public String getInput() throws IOException {
        return reader.readLine();
    }
}
