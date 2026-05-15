package homework.lesson3.additionalTask;

public abstract class Product {

    double price;
    String name;

    protected Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price= " + price +
                ", name= '" + name + '\'' +
                '}';
    }
}
