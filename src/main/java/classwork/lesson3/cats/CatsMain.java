package classwork.lesson3.cats;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatsMain {

    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Кузя"));
        cats.add(new Cat("Мурчик"));
        cats.add(new Cat("Пузік"));
        cats.add(new Cat("Зюзік"));
        cats.add(new Cat("Синхрофазатрон"));


        addCatByName(cats, "Крабік");
        System.out.println(cats);
        removeCatByName(cats, "Мурчик");
        System.out.println(cats);
    }

    public static void addCatByName(List<Cat> cats, String name) {

        boolean isFound = false;
        for (Cat cat : cats) {
            if (cat.getName().equals(name)) {
                isFound = true;
                break;
            }
        }
        if (!isFound){
            cats.add(new Cat(name));
        }
    }

    public static void removeCatByName(List<Cat> cats, String name) {
        Iterator<Cat> catIterator = cats.iterator();
        while (catIterator.hasNext()) {
            Cat cat = catIterator.next();
            if (cat.getName().equals(name)) {
                catIterator.remove();
            }
        }
    }

//    // не працює, викидає ConcurrentModificationException
//    public static void removeCatByName(List<Cat> cats, String name){
//        for (Cat cat: cats){
//            if (cat.getName().equals(name)){
//                cats.remove(cat);
//            }
//        }
//    }
//
//    // не працює, викидає ConcurrentModificationException
//    public static void addCatByName(List<Cat> cats, String name){
//        for (Cat cat: cats){
//            if (cat.getName().equals(name)){
//                cats.add(new Cat(name));
//            }
//        }
//    }
}
