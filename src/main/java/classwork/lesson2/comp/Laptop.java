package classwork.lesson2.comp;

public class Laptop extends Computer {

    String battery;

    public Laptop(String processor, int ram, Drive storage, String os, String battery) {
        super(processor, ram, storage, os);
        this.battery = battery;
    }

    @Override
    public void hibernate(){
        System.out.println("Hibernating, being closed");
    }

    @Override
    public void printSpecs() {
        System.out.println("I am MacBook");
    }

    @Override
    public void doStuff() {
        System.out.println("LAPTOP");
    }
}
