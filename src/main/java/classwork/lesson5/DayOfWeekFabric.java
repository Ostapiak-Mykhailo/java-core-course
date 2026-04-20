package classwork.lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DayOfWeekFabric {

    public static void main(String[] args) throws IOException {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input day of week");
        System.out.println(Arrays.toString(DayOfWeek.values())); // видрукувати опції
        String input = READER.readLine().toUpperCase();
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(input);

//        System.out.println(createTask(dayOfWeek));

        System.out.println(createTaskByMap(dayOfWeek));

    }

    // завдання через список
    private static String createTask(DayOfWeek dayOfWeek) {
        String task = "";
        switch (dayOfWeek) {
            case MONDAY -> task = "today window washing";
            case TUESDAY -> task = "today we water flowers";
            case WEDNESDAY -> task = "today we repairing tables";
            case THURSDAY -> task = "today we washing tables";
            case FRIDAY -> task = "today we read books";
            case SATURDAY -> task = "today we dusting";
            case SUNDAY -> task = "today relax";
        }
        return task;
    }

    // завдання через мапу
    private static String createTaskByMap(DayOfWeek dayOfWeek) {
        Map<DayOfWeek, String> map = new HashMap<>();
        map.put(DayOfWeek.MONDAY, "today window washing");
        map.put(DayOfWeek.TUESDAY, "today we water flowers");
        map.put(DayOfWeek.WEDNESDAY, "today we repairing tables");
        map.put(DayOfWeek.THURSDAY, "today we read books");
        map.put(DayOfWeek.FRIDAY, "today we dusting");
        map.put(DayOfWeek.SATURDAY, "today relax");
        return map.get(dayOfWeek);
    }
}
