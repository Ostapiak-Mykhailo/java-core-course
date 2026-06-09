package homework.lesson9.homeTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void runApp() throws IOException {
        System.out.println("Welcome to our web site. Please enter your name to check in");
        String name;
        boolean validName;
        do {
            name = getInput();
            validName = validateName(name);
            if (!validName) {
                System.out.println("Input error. Name must contain letters only and its length at least 3 characters");
            }
        } while (!validName);
        System.out.println("Enter your Email");
        String email;
        boolean validEmail;
        do {
            email = getInput();
            validEmail = validateEmail(email);
            if (!validEmail) {
                System.out.println("Incorrect input. Please try again");
            }
        } while (!validEmail);
        System.out.println("Enter your phone number");
        String number;
        boolean validNumber;
        do {
            number = getInput();
            validNumber = validatePhoneNumber(number);
            if (!validNumber) {
                System.out.println("Incorrect input. Please try again");
            }
        } while (!validNumber);

        System.out.println("Come up with strong password");
        String password;
        boolean validPassword;
        do {
            password = getInput();
            validPassword = validatePassWord(password);
            if (!validPassword) {
                System.out.println("Reliable password must contain at least 1 digit, one capital letter and " +
                        "one special symbol. Please enter another password");
            }
        } while (!validPassword);
        String password1;
        System.out.println("Confirm your password");
        do {
            password1 = getInput();
            if (!password1.equals(password)) {
                System.out.println("Passwords do not match. Please try again");
            }
        } while (!password1.equals(password));
        System.out.println("Congratulations: you have successfully registered on our website");
    }

    private String getInput() throws IOException {
        return reader.readLine();
    }

    private boolean validateName(String string) {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]{3,256}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private boolean validateEmail(String string) {
        Pattern pattern = Pattern.compile("^([\\w-&&[^а-яА-Я]]{3,})@([\\w-&&[^а-яА-Я]]+)\\.([\\w-&&[^а-яА-Я]]{2,})(\\.?([\\w-&&[^а-яА-Я]]{2,}))?$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private boolean validatePhoneNumber(String string) {
        Pattern pattern = Pattern.compile("^[+]?38(067|068|096|097|098|050|066|075|095|099|063|073|093)\\d{7}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    private boolean validatePassWord(String string) {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*\\W)(?=.*[A-ZА-Я])\\S{8,}$");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
