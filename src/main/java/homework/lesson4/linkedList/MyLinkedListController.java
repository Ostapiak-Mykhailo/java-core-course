package homework.lesson4.linkedList;

public class MyLinkedListController {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//    }
        list.add(0, 5);
        list.add(0, 10);
        list.add(2, 8);
        list.add(1, 4);
        System.out.println(list);

        list.add(15);
        list.add(2);
        System.out.println(list);

        list.addFirst(5);
        System.out.println(list);

        System.out.println(list.get(5));

        list.set(0, 0);
        list.set(5, 100);
        System.out.println(list);

        list.remove(0);
        list.remove(4);
        System.out.println(list);
    }
}
