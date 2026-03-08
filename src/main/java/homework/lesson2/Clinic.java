package homework.lesson2;

public class Clinic {

    public static void main(String[] args) {

        Animal cat = new Cat("Baton", 5, 3);
        Animal dog = new Dog("Duke", 4, 15);
        Animal hamster = new Hamster("Piggy", 1, 1);

        Client client1 = new Client("Anna", cat);
        Client client2 = new Client("Manna", dog);
        Client client3 = new Client("Vanna", hamster);

        Visit visit1 = new CheckUpVisit(client1, cat);
        visit1.executeVisit();
        System.out.println();
        Visit visit2 = new SickVisit(client2, dog);
        visit2.executeVisit();
        System.out.println();
        Visit visit3 = new VaccinationVisit(client3, hamster);
        visit3.executeVisit();

    }
}
