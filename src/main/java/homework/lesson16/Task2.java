package homework.lesson16;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        String text1 = "f , 25fff4832";
        String text2 = "25483ggggggg54756535";
        String text3 = "254835";

        System.out.println(ifNumberNrepeatedNTimes(text1));
        System.out.println(ifNumberNrepeatedNTimes(text2));
        System.out.println(ifNumberNrepeatedNTimes(text3));

        System.out.println();

        System.out.println(ifNumberNrepeatedNTimesByMap(text1));
        System.out.println(ifNumberNrepeatedNTimesByMap(text2));
        System.out.println(ifNumberNrepeatedNTimesByMap(text3));

        System.out.println();

        System.out.println(ifNumberNrepeatedNTimesByStream(text1));
        System.out.println(ifNumberNrepeatedNTimesByStream(text2));
        System.out.println(ifNumberNrepeatedNTimesByStream(text3));
    }

    private static boolean ifNumberNrepeatedNTimes(String string) {
        string = validateInput(string);
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

    private static boolean ifNumberNrepeatedNTimesByMap(String string) {
        string = validateInput(string);
        String[] strNumbers = string.split("");
        Map<Integer, Integer> map = new HashMap<>();

        for (String strNumber : strNumbers) {
            int number = Integer.parseInt(strNumber);
            map.merge(number, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    private static boolean ifNumberNrepeatedNTimesByStream(String string) {
        string = validateInput(string);
        return string.chars().map(a -> a - '0').boxed().collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().anyMatch(e -> e.getKey().equals(e.getValue().intValue()));
    }

    private static String validateInput(String s) {
        return s.replaceAll("\\D", "");
    }
}
