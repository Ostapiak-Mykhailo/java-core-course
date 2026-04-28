package classwork.lesson2.comp;

public class Office {

    Equipment[] equipment;
    int equipmentCount;

    public Office() {
        this.equipment = new Equipment[3];
        this.equipmentCount = 0;
    }

    public void addEquipment(Equipment equipment) {
        this.equipment[equipmentCount++] = equipment;
    }

    public Equipment[] getEquipment() {
        return equipment;
    }
}
