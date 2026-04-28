package homework.lesson2;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

    public static void main(String[] args) {

        List<Animal> list1 = new ArrayList<>();
        List<Animal> list2 = new ArrayList<>();
        List<Animal> list3 = new ArrayList<>();

        Animal cat = new Cat("Baton", 5, 3);
        Animal dog = new Dog("Duke", 4, 15);
        Animal hamster = new Hamster("Piggy", 1, 1);
        Animal dog2 = new Dog("Kusia", 3, 5);
        Client client1 = new Client("Anna", list1);
        Client client2 = new Client("Manna", list2);
        Client client3 = new Client("Vanna", list3);

        client1.getAnimals().add(cat);
        Visit visit1 = new CheckUpVisit(client1, cat);
        visit1.executeVisit();
        System.out.println();

        client2.getAnimals().add(dog);
        Visit visit2 = new SickVisit(client2, dog);
        visit2.executeVisit();
        System.out.println();

        client3.getAnimals().add(hamster);
        client3.getAnimals().add(dog2);
        Visit visit3 = new VaccinationVisit(client3, hamster);
        visit3.executeVisit();
        visit3.executeVisit();

    }
}
