package homework.lesson9.hometask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserCreator {

    private ConsoleReader reader = new ConsoleReader();
    private Validator validator;
    private final List<User> users = new ArrayList<>();
    private final String namePrompt = "Welcome to our web site. Please enter your name to check in";
    private final String emailPrompt = "Enter your Email";
    private final String numberPrompt = "Enter your phone number";
    private final String passwordPrompt = "Come up with strong password";
    private final String confirmPasswordPrompt = "Confirm your password";

    public UserCreator(Validator validator) {
        this.validator = validator;
    }

    public void runApp() throws IOException {
        String name = getValidInput(namePrompt);
        validator.validateName(name);

        String email = getValidInput(emailPrompt);
        validator.validateEmail(email);

        String number = getValidInput(numberPrompt);
        validator.validatePhoneNumber(number);

        String password = getValidInput(passwordPrompt);
        validator.validatePassWord(password);

        if (!confirmPassword(password)) {
            throw new ValidationException("Passwords do not match");
        }
        User user = new User(name, email, number, password);
        users.add(user);

        System.out.println("Congratulations: you have successfully registered on our website");
    }

    private boolean confirmPassword(String password) throws IOException {
        return password.equals(getValidInput(confirmPasswordPrompt));
    }

    private String getValidInput(String message) throws IOException {
        System.out.println(message);
        return reader.getInput();
    }
}
