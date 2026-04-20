package classwork.lesson5;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args) {

        HashMap<String, Integer> employees = new HashMap<>();
        employees.put("HR", 20);
        employees.put("DEV", 50);
        employees.put("MANAGEMENT", 15);

        employees.put(null, 1);

        Set<String> deps = employees.keySet(); // ключі мапи у вигляді Set
        System.out.println(deps);

        Collection<Integer> values = employees.values(); // значення витягуються у Collection
        System.out.println(values);

        for (Map.Entry<String, Integer> entry: employees.entrySet()){
            System.out.println(entry.getKey() + " - key; " + entry.getValue() + " - value");
        }

        System.out.println(employees.get("HR"));

        Set<String> departments = new HashSet<>();
        departments.add("HR");
        departments.add("DEV");
        departments.add("MANAGEMENT");

        // ітерація по Set
        for (String department : departments) {
            System.out.println(department);
        }
        System.out.println();

        // видалення із Set
        departments.remove("DEV");
        for (String department : departments) {
            System.out.println(department);
        }

        if (departments.contains("DEV")){
            System.out.println("developers are here");
        } else {
            System.out.println("developers are NOT here");
        }
    }
}
