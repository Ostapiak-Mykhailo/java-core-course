package homework.lesson9.hometask;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            Validator validator = new Validator();
            UserCreator creator = new UserCreator(validator);
            creator.runApp();
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
