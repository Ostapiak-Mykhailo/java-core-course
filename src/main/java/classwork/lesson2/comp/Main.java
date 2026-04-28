package classwork.lesson2.comp;

public class Main {

    public static void main(String[] args) {

        Computer pc = new Desktop("Intel", 16, Drive.HDD, "Windows", "BeQuite");
        Computer mac = new Laptop("M1", 8, Drive.HDD, "MacOS", "Integrated");

        Office office = new Office();

        office.addEquipment(pc);
        office.addEquipment(mac);
        office.addEquipment(new Chair());

        System.out.println(office.getEquipment()[0].getInventoryNumber());

        if (pc instanceof Desktop){
            System.out.println("DESKTOP");
        } else if (pc instanceof Laptop){
            System.out.println("LAPTOP");
        }

        System.out.println("Replace condition with polymorphism");

        doStuff(pc);
        doStuff(mac);


        pc.printSpecs();
        mac.printSpecs();

        pc.hibernate();
        mac.hibernate();

        printAllNumbers(office.getEquipment());
    }

    public static void doStuff(Computer desktop){
        desktop.doStuff();
    }

    public static void printAllNumbers(Equipment[] equipmentArray){
        for (Equipment equipment1 : equipmentArray) {
            System.out.println(equipment1.getInventoryNumber());
        }
    }
}
