package homework.lesson9.hometask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCreator {

    private final ConsoleReader reader = new ConsoleReader();
    private final Validator validator;
    private final List<User> users = new ArrayList<>();

    public UserCreator(Validator validator) {
        this.validator = validator;
    }

    public void runApp() throws IOException {
        String name = getValidInput("Welcome to our web site. Please enter your name to check in");
        validator.validateName(name);

        String email = getValidInput("Enter your Email");
        validator.validateEmail(email);

        String number = getValidInput("Enter your phone number");
        validator.validatePhoneNumber(number);

        String password = getValidInput("Come up with strong password");
        validator.validatePassWord(password);

        if (!confirmPassword(password)) {
            throw new ValidationException("Passwords do not match");
        }
        User user = new User(name, email, number, password);
        users.add(user);

        System.out.println("Congratulations: you have successfully registered on our website");
    }

    private boolean confirmPassword(String password) throws IOException {
        return password.equals(getValidInput("Confirm your password"));
    }

    private String getValidInput(String message) throws IOException {
        System.out.println(message);
        return reader.getInput();
    }
}
