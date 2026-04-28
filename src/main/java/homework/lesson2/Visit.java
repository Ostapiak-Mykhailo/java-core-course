package homework.lesson2;

import java.util.List;

public abstract class Visit implements Diagnosable{

    protected String description;
    protected Client client;
    protected Animal animal;

    public Visit(Client client, Animal animal) {
        this.client = client;
        this.animal = animal;
    }

    protected void executeVisit() {
        takeHistory(animal);
        toDiagnose(client);
        toVaccinate();
        toTreat(client);
        toRecommend();
        fillHistory(animal);
    }

    protected void takeHistory(Animal animal) {
        List<Visit> history = animal.getHistory();
        if (history.isEmpty()) {
            System.out.println("No records found");
            return;
        }
        for (Visit h : history) {
            System.out.println(h.getDescription());
        }
    }


    @Override
    public void toDiagnose(Client client) {
        System.out.println("The doctor made a diagnosis");
    }

    protected void toVaccinate() {

    }

    protected void toTreat(Client client) {

    }

    protected void toRecommend() {

    }

    protected void fillHistory(Animal animal) {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
