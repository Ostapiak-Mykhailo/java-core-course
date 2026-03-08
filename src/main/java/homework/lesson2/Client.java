package homework.lesson2;

public class Client {

    private final String name;
    private Animal animal;

    public Client(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }

    public Visit goToClinic(Visit visit) {
        return visit;
    }

    public Animal getAnimal() {
        return animal;
    }
}
