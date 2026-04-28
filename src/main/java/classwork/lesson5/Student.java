package classwork.lesson5;

public class Student {

    private String name;
    private DayOfWeek onDutyAt;

    public Student(String name, DayOfWeek onDutyAt){
        this.name = name;
        this.onDutyAt = onDutyAt;
    }

    public String getName() {
        return name;
    }

    public DayOfWeek getOnDutyAt() {
        return onDutyAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scheduleAt=" + onDutyAt +
                '}';
    }
}
