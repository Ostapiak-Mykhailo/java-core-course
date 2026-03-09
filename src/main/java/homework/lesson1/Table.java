package homework.lesson1;

public class Table {

    private int number;
    private boolean isBooked;

    public Table(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Table{" +
                "number=" + number +
                '}';
    }
}
