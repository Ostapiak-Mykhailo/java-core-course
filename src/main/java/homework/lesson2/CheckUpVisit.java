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
    protected void toDiagnose() {
        System.out.println("The doc has not diagnosed any illness. " + getAnimal().getName() + " " +
                "is in very good condition");
    }

    @Override
    protected void toTreat() {
        System.out.println(getAnimal().getName() + " does not need any treatment");
    }
}
