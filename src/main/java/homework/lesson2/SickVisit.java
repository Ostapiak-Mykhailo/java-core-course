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
    protected void takeHistory() {
        System.out.println("The doctor took history");
    }

    @Override
    protected void toDiagnose(Client client) {
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
}
