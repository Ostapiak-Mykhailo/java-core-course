package classwork.lesson5;

public class Bird {

    private String color;

    public Bird(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "color - '" + color + '\'' +
                '}';
    }
}
