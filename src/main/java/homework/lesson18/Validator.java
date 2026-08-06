package homework.lesson18;

public class Validator {

    String validateInput(String string) {
        return string.replaceAll("\\D", "");
    }
}
