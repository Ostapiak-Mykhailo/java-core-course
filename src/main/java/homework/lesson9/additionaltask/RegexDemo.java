package homework.lesson9.additionaltask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {

        String date1 = "28-06-2025";
        String date2 = "34-06-2025";

        dateFormatting(date1);
        System.out.println();
        dateFormatting(date2);
        System.out.println();

        String string1 = "Why regexes are so difficult?";
        String string2 = "Why regexes   are so   difficult?";

        deleteHiatuses(string1);
        System.out.println();
        deleteHiatuses(string2);
        System.out.println();

        String string3 = "I have many dollars and euros";
        String string4 = "I 655 have 100 dollars and 50 euros 48";

        findNumbers(string3);
        System.out.println();
        findNumbers(string4);
        System.out.println();

        String string5 = "I don`t want to be Python , C or C++ developer. I want to be JAVA developer";
        forbidWords(string5);
    }

    // Перевірте, чи відповідає рядок формату DD-MM-YYYY.
    // Додатково переконайтеся, що дні знаходяться в межах 01-31, а місяці — 01-12.
    public static void dateFormatting(String date) {
        Pattern pattern = Pattern.compile("^(?<day>0[1-9]|[1-2][0-9]|3[0-1])-" +
                "(?<month>0[1-9]|1[1-2])-" +
                "(?<year>(19[0-9]{2})|(20([0-1][0-9]|2[0-6])))$");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find()) {
            System.out.println("Day: " + matcher.group("day"));
            System.out.println("Month: " + matcher.group("month"));
            System.out.println("Year: " + matcher.group("year"));
        } else {
            System.out.println("Your string does not match with the pattern");
        }
        System.out.println(matcher.matches());
    }

    // Видалення зайвих пробілів: Напишіть шаблон для пошуку двох або більше послідовних пробілів у тексті
    // та замініть їх на один пробіл
    public static void deleteHiatuses(String string) {
        Pattern pattern = Pattern.compile("\\s{2,}");
        Matcher matcher = pattern.matcher(string);
        if (!matcher.find()) {
            System.out.println("There`s no hiatuses to replace");
        } else {
            System.out.println(matcher.replaceAll(" "));
        }
    }

    public static void findNumbers(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);
        boolean found = false;
        while (matcher.find()) {
            found = true;
            System.out.println("Your string contains such number: " + matcher.group());
        }
        if (!found){
            System.out.println("Your string does not contain numbers");
        }
    }

    // Заміна заборонених слів: Створіть регулярний вираз, який знаходить список небажаних слів
    // (наприклад, badword1, badword2) і замінює їх на символи ***, ігноруючи регістр літер.
    public static void forbidWords(String string) {
        Pattern pattern = Pattern.compile("(python)|(c)|(c\\+\\+)+?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        String result = matcher.replaceAll(match -> "*".repeat(match.group().length()));
        System.out.println(result);
    }
}
