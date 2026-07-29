package homework.lesson17;

public class MathChallenge {


    public static void main(String[] args) {

        String string1 = "2+(3-1)*3"; //8
        String string2 = "(2-0)*(6/2)"; // 6
        String string3 = "6*(4/2)+3*1"; //15
        String string4 = "6/3-1"; //1
        System.out.println(mathChallenge(string1));
        System.out.println(mathChallenge(string2));
        System.out.println(mathChallenge(string3));
        System.out.println(mathChallenge(string4));
    }

    private static int mathChallenge(String str) {
        while (str.contains("(")) {
            int openIndex = str.lastIndexOf('(');
            int closeIndex = str.indexOf(')', openIndex);
            String inside = str.substring(openIndex + 1, closeIndex);
            int result = calculate(inside);
            String before = str.substring(0, openIndex);
            String after = str.substring(closeIndex + 1);

            str = before + result + after;
        }
        return calculate(str);
    }

    private static int calculate(String string) {
        string = calculateOperators(string, '*', '/');
        string = calculateOperators(string, '+', '-');
        return Integer.parseInt(string);
    }

    private static String calculateOperators(String string, char first, char second) {

        while (string.contains(String.valueOf(first)) || string.contains(String.valueOf(second))) {
            int operatorIndex = getOperatorIndex(string, first, second);
            int leftStart = findStartLeft(string, operatorIndex);
            int rightEnd = findStartRight(string, operatorIndex);
            String leftString = string.substring(leftStart, operatorIndex);
            String rightString = string.substring(operatorIndex + 1, rightEnd + 1);
            int left = Integer.parseInt(leftString);
            int right = Integer.parseInt(rightString);
            int result = getResult(string, operatorIndex, left, right);
            String before = string.substring(0, leftStart);
            String after = string.substring(rightEnd + 1);
            string = before + result + after;
        }
        return string;
    }

    private static int getResult(String string, int operatorIndex, int left, int right) {
        return switch (string.charAt(operatorIndex)) {
            case '*' -> left * right;
            case '/' -> left / right;
            case '-' -> left - right;
            case '+' -> left + right;
            default -> 0;
        };
    }

    private static int getOperatorIndex(String string, char first, char second) {
        int index = -1;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == first || ch == second) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findStartLeft(String s, int operatorIndex) {
        int index = operatorIndex - 1;
        while (index >= 0 && Character.isDigit(s.charAt(index))) {
            index--;
        }
        return index + 1;
    }

    private static int findStartRight(String s, int operatorIndex) {
        int index = operatorIndex + 1;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            index++;
        }
        return index - 1;
    }
}
