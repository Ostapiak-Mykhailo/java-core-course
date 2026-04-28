package homework.lesson2;

public class CheckUpVisit extends Visit {

    public CheckUpVisit(Client client, Animal animal) {
        super(client, animal);
    }

    @Override
    protected void executeVisit() {
        super.executeVisit();
    }

    @Override
    public void toDiagnose(Client client) {
        super.toDiagnose(client);
        System.out.println("The doc has not diagnosed any illness. " + animal.getName() + " " +
                "is in very good condition");
    }

    @Override
    protected void toTreat(Client client) {
        System.out.println(animal.getName() + " does not need any treatment");
    }

    @Override
    protected void fillHistory(Animal animal) {
        String record = "The patient was examined. Condition is satisfactory.";
        Visit history = new CheckUpVisit(client, animal);
        animal.getHistory().add(history);
    }
}
