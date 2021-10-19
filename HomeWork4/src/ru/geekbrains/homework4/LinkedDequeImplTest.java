package ru.geekbrains.homework4;

public class LinkedDequeImplTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedDequeImpl<>();

        // добавить элемент слева
        deque.insertLeft(1);
        deque.insertLeft(3);
        deque.insertLeft(5);

        // добавить элемент справа
        deque.insertRight(2);
        deque.insertRight(4);
        deque.insertRight(8);

        deque.display();

        System.out.println("Первый слева " + deque.peekFrontLeft());
        System.out.println("Первый справа " + deque.peekFrontRight());
        System.out.println("Размер " + deque.size());
        System.out.println("Пустой ли дек " + deque.isEmpty());

        // удалить первый элемент слева
        System.out.println("Удален первый элемент слева " + deque.removeLeft());
        // удалить первый элемент справа
        System.out.println("Удален первый элемент справа " + deque.removeRight());

        deque.display();


    }
}
