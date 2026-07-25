package homework.lesson16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {
        String text1 = "254832";
        String text2 = "2548354756535";
        String text3 = "254835";

        System.out.println(ifNumberNrepeatedNTimes(text1));
        System.out.println(ifNumberNrepeatedNTimes(text2));
        System.out.println(ifNumberNrepeatedNTimes(text3));
    }

    private static boolean ifNumberNrepeatedNTimes(String string) {
        if (!validateInput(string)){
            throw new IllegalArgumentException();
        }
        String[] strNumbers = string.split("");
        int[] numbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        for (int number : numbers) {
            int count = 0;
            for (int i : numbers) {
                if (number == i) {
                    count++;
                }
            }
            if (number == count) {
                return true;
            }
        }
        return false;
    }

    private static boolean validateInput(String s){
         Pattern pattern = Pattern.compile("[2-9]+");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
