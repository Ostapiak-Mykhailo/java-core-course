package homework.lesson2;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private final String name;
    private int age;
    private int weight;
    private List<Visit> history = new ArrayList<>();

    public Animal(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public List<Visit> getHistory() {
        return history;
    }

    public void setHistory(List<Visit> history) {
        this.history = history;
    }
}
