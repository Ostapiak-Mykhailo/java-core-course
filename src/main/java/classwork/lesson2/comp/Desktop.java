package classwork.lesson2.comp;

public class Desktop extends Computer {

    String cpuCooler;

    public Desktop(String processor, int ram, Drive storage, String os, String cpuCooler) {
        super(processor, ram, storage, os);
        this.cpuCooler = cpuCooler;
    }

    @Override
    public void hibernate() {
        System.out.println("I just hibernate");
    }

    @Override
    public void printSpecs() {
        super.printSpecs();
        System.out.println("Also i am a desktop");
    }

    @Override
    public void doStuff() {
        System.out.println("DESKTOP");
    }
}
