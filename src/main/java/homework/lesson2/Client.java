package homework.lesson2;

import java.util.List;

public class Client {

    private final String name;
    private List<Animal> animals;

    public Client(String name, List<Animal> animals) {
        this.name = name;
        this.animals = animals;
    }

    public Visit goToClinic(Visit visit) {
        return visit;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
