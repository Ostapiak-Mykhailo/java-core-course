package homework.lesson9.hometask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    void validateName(String string) {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]{3,256}$");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new ValidationException("Input error. Name must contain letters only and its length at least 3 characters");
        }
    }

    void validateEmail(String string) {
        Pattern pattern = Pattern.compile("^([\\w-&&[^а-яА-Я]]{3,})@([\\w-&&[^а-яА-Я]]+)\\.([\\w-&&[^а-яА-Я]]{2,})" +
                "(\\.?([\\w-&&[^а-яА-Я]]{2,}))?$");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect input");
        }
    }

    void validatePhoneNumber(String string) {
        Pattern pattern = Pattern.compile("^[+]?38(067|068|096|097|098|050|066|075|095|099|063|073|093)\\d{7}$");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new ValidationException("Incorrect input");
        }
    }

    void validatePassWord(String string) {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*\\W)(?=.*[A-ZА-Я])\\S{8,}$");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.matches()) {
            throw new ValidationException("This password isn`t reliable enough. Reliable password must contain at least " +
                    "1 digit, one capital letter and one special symbol");
        }
    }
}
