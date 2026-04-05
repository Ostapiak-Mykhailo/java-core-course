package homework.lesson4.map;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, LocalDate> map = new HashMap<>();
        LocalDate date1 = LocalDate.of(2000, 12, 12);
        LocalDate date2 = LocalDate.of(2000, 1, 5);
        LocalDate date3 = LocalDate.of(2000, 2, 1);
        LocalDate date4 = LocalDate.of(2000, 4, 25);
        LocalDate date5 = LocalDate.of(2000, 6, 18);
        LocalDate date6 = LocalDate.of(2000, 3, 6);
        LocalDate date7 = LocalDate.of(2000, 10, 30);
        LocalDate date8 = LocalDate.of(2000, 11, 22);
        LocalDate date9 = LocalDate.of(2000, 9, 20);
        LocalDate date10 = LocalDate.of(2000, 8, 1);

        map.put("Ivanov", date1);
        map.put("Petrenko", date2);
        map.put("Shevchenko", date3);
        map.put("Melnyk", date4);
        map.put("Kovalenko", date5);
        map.put("Tkachenko", date6);
        map.put("Hrytsenko", date7);
        map.put("Pupkin", date8);
        map.put("Marchenko", date9);
        map.put("Bondarenko", date10);

        System.out.println(map);

//        for (Map.Entry<String, LocalDate> entry : map.entrySet()) {
//            if (entry.getValue().getMonth().equals(Month.JANUARY) || entry.getValue().getMonth().equals(Month.FEBRUARY)
//                    || entry.getValue().getMonth().equals(Month.DECEMBER)) {
//map.remove(entry.getKey());
//            }
//        }
        Iterator<Map.Entry<String, LocalDate>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, LocalDate> entry = iterator.next();
            if (entry.getValue().getMonth().equals(Month.DECEMBER) || entry.getValue().getMonth().equals(Month.JANUARY)
            || entry.getValue().getMonth().equals(Month.FEBRUARY)){
                iterator.remove();
            }
        }
        System.out.println(map);
    }
}
