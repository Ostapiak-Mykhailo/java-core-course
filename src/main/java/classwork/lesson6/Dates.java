package classwork.lesson6;

import java.time.LocalDate;

public class Dates {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now(); // поточна дата
        System.out.println(now);

        LocalDate notToday = LocalDate.parse("2026-11-05");
        System.out.println(notToday);

        System.out.println(now.minusDays(3)); // мінус 3 дні

        if (notToday.isAfter(now)){
            System.out.println("future");
        } else {
            System.out.println("past");
        }
    }
}
