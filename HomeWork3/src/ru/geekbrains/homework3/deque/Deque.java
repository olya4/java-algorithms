package ru.geekbrains.homework3.deque;

public interface Deque<E> {
    // добавить элемент слева
    boolean insertLeft(E value);

    // добавить элемент справа
    boolean insertRight(E value);

    // удалить элемент слева
    E removeLeft();

    // удалить элемент справа
    E removeRight();

    // ближайший первый слева
    E peekFrontLeft();

    // ближайший первый справа
    E peekFrontRight();

    // размер дека
    int size();

    // пустой ли дек
    boolean isEmpty();

    // полный ли дек
    boolean isFull();

    // показать содержимое дека
    void display();
}