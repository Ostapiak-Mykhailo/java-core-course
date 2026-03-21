package homework.lesson2;

public class VaccinationVisit extends Visit {

    public VaccinationVisit(Client client, Animal animal) {
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
        System.out.println("The doctor determined the need for vaccination");
    }

    @Override
    protected void toVaccinate() {
        System.out.println("The doctor vaccinated the pet");
    }

    @Override
    protected void toRecommend() {
        System.out.println("Come again in six months");
    }

    @Override
    protected void fillHistory(Animal animal) {
        String record = animal.getName() + " was vaccinated. No complications observed. " +
                "Next vaccination is recommended in 6 months.";
        History history = new History(record);
        animal.getRecords().add(history);
    }
}
