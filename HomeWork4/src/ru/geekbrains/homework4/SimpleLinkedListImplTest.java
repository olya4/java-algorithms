package ru.geekbrains.homework4;

public class SimpleLinkedListImplTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();

        // добавление элементов в список
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);

        // вывод содержимого списка
        linkedList.display();

        // входит ли элемент в список
        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        // удалить первый элемент из списка
        linkedList.removeFirst();
        linkedList.display();

        // удалить элемент по значению
        linkedList.remove(4);
        linkedList.remove(8);
        linkedList.display();


        SimpleLinkedListImpl<Integer> linkedList1 = new SimpleLinkedListImpl<>();

        for (Integer value : linkedList1) {
            System.out.println("value: " + value);
        }
    }
}
