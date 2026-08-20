package homework.lesson18;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Validator validator = new Validator();
        View view = new View();
        Drawing drawing = new Drawing(validator, view);
        drawing.startApp();
    }
}
