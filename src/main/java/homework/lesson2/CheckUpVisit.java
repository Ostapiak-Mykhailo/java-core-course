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
    protected void toDiagnose(Client client) {
        System.out.println("The doc has not diagnosed any illness. " + client.getAnimal().getName() + " " +
                "is in very good condition");
    }

    @Override
    protected void toTreat(Client client) {
        System.out.println(client.getAnimal().getName() + " does not need any treatment");
    }
}
