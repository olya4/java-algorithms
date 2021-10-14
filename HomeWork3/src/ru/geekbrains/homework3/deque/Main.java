package ru.geekbrains.homework3.deque;

public class Main {
    public static void main(String[] args) {
        testDeque();
    }

    private static void testDeque() {
        Deque<Integer> deque = new DequeImpl<>(4);

        System.out.println("add element: " + deque.insertLeft(1));
        System.out.println("add element: " + deque.insertLeft(5));
        System.out.println("add element: " + deque.insertRight(1));
        System.out.println("add element: " + deque.insertRight(8));

        System.out.println("add element: " + deque.insertLeft(9));
        System.out.println("add element: " + deque.insertRight(10));

        deque.display();

        System.out.println("First element on left: " + deque.peekFrontLeft());
        System.out.println("First element on right: " + deque.peekFrontRight());

        System.out.println("Remove first element on left: " + deque.removeLeft());
        System.out.println("Remove first element on right: " + deque.removeRight());

        deque.display();
    }
}
