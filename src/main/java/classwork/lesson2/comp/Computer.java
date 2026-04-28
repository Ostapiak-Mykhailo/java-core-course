package classwork.lesson2.comp;

public abstract class Computer implements Equipment{
    String processor;
    int ram;
    Drive storage;
    String os;

    public Computer(String processor, int ram, Drive storage, String os) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    public void printSpecs(){
        System.out.println("Computer{" +
                "processor = '" + processor + '\'' +
                ", ram = '" + ram + '\'' +
                ", storage = " + storage +
                ", os = '" + os + '\'' +
                '}');
    }

    public abstract void hibernate();

    @Override
    public int getInventoryNumber(){
        return  69;
    }

    public abstract void doStuff();
}
