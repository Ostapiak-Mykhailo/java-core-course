package homework.lesson2;

public class VaccinationVisit extends Visit {

    public VaccinationVisit(Client client, Animal animal) {
        super(client, animal);
    }

    @Override
    protected void executeVisit() {
        toVaccinate();
        super.executeVisit();
    }

    private void toVaccinate() {
        System.out.println("The doctor vaccinated the pet");
    }

    @Override
    protected void toRecommend() {
        System.out.println("Come again in six months");
    }
}
