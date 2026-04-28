package classwork.lesson5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Scheduler {

    public static void main(String[] args) throws IOException {

        BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input day of week");
        System.out.println(Arrays.toString(DayOfWeek.values())); // видрукувати опції
        String input = READER.readLine().toUpperCase();
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(input);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Masha", DayOfWeek.MONDAY));
        students.add(new Student("Ira", DayOfWeek.TUESDAY));
        students.add(new Student("Nikita", DayOfWeek.WEDNESDAY));
        students.add(new Student("Nazar", DayOfWeek.THURSDAY));
        students.add(new Student("Tania", DayOfWeek.FRIDAY));
        students.add(new Student("Ivan", DayOfWeek.SATURDAY));

        Map<DayOfWeek, Student> map = new HashMap<>(); // переганяєм список у мапу
        for (Student student : students){
            map.put(student.getOnDutyAt(), student);
        }
        Student onDutyStudent = map.get(dayOfWeek); // визначаєм студента на чергуванні з мапи
        System.out.println(onDutyStudent.getName() + " is on duty " + dayOfWeek);


        for (Student student : students){ // визначаєм студента на чергуванні зі списку
            System.out.println(student);

            if (dayOfWeek.equals(student.getOnDutyAt())){
                System.out.println(student.getName() + " is on duty " + dayOfWeek);
            }
        }

    }
}
