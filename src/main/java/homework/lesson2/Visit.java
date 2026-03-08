package homework.lesson2;

public abstract class Visit {

    private Client client;
    private Animal animal;

    public Visit(Client client, Animal animal) {
        this.client = client;
        this.animal = animal;
    }

    protected void executeVisit() {
        takeHistory();
        toDiagnose();
        toTreat();
        toRecommend();
    }

    protected void takeHistory() {
    }

    protected void toDiagnose() {

    }

    protected void toTreat() {

    }

    protected void toRecommend() {

    }
}
