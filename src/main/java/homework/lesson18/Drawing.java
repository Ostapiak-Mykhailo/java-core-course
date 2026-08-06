package homework.lesson18;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Drawing {

    private final Map<Character, String[]> map = new HashMap<>();
    private final Validator validator;
    private final View view;

    public Drawing(Validator validator, View view) {
        this.validator = validator;
        this.view = view;
    }

    public void startApp() throws IOException {
        fillMap();
        String string = view.getInput();
        string = validator.validateInput(string);
        drawDigits(string);
    }

    private void drawDigits(String string) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < string.length(); j++) {
                System.out.print(map.get(string.charAt(j))[i] + " ");
            }
            System.out.println();
        }
    }

    private void fillMap() {
        map.put('0', new String[]{
                " @@@ ",
                "@   @",
                "@   @",
                "@   @",
                " @@@ "
        });

        map.put('1', new String[]{
                "  @  ",
                " @@  ",
                "  @  ",
                "  @  ",
                "@@@@ "
        });

        map.put('2', new String[]{
                " @@@@ ",
                "    @",
                " @@@ ",
                "@    ",
                "@@@@@"
        });

        map.put('3', new String[]{
                "@@@@ ",
                "    @",
                " @@@ ",
                "    @",
                "@@@@ "
        });

        map.put('4', new String[]{
                "@   @",
                "@   @",
                "@@@@@",
                "    @",
                "    @"
        });

        map.put('5', new String[]{
                "@@@@@",
                "@    ",
                "@@@@ ",
                "    @",
                "@@@@ "
        });

        map.put('6', new String[]{
                " @@@ ",
                "@    ",
                "@@@@ ",
                "@   @",
                " @@@ "
        });

        map.put('7', new String[]{
                "@@@@@",
                "    @",
                "   @ ",
                "  @  ",
                " @   "
        });

        map.put('8', new String[]{
                " @@@ ",
                "@   @",
                " @@@ ",
                "@   @",
                " @@@ "
        });

        map.put('9', new String[]{
                " @@@ ",
                "@   @",
                " @@@@",
                "    @",
                " @@@ "
        });
    }
}
