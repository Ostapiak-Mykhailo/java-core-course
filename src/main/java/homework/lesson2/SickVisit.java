package homework.lesson2;

public class SickVisit extends Visit {

    public SickVisit(Client client, Animal animal) {
        super(client, animal);
    }

    @Override
    protected void executeVisit() {
        super.executeVisit();
    }

    @Override
    protected void takeHistory(Animal animal) {
        super.takeHistory(animal);
    }

    @Override
    public void toDiagnose(Client client) {
        super.toDiagnose(client);
        System.out.println("The doc has diagnosed a broken paw");
    }

    @Override
    protected void toTreat(Client client) {
        System.out.println("The doctor applied a cast");
    }

    @Override
    protected void toRecommend() {
        System.out.println("Do not remove the cast for a month");
    }

    @Override
    protected void fillHistory(Animal animal) {
        String record = "Diagnosed with a broken paw. A cast was applied. Rest is required for one month.";
        History history = new History(record);
        animal.getRecords().add(history);
    }
}
