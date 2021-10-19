package ru.geekbrains.homework4;


public interface Deque<E> {

    // добавить элемент слева
    boolean insertLeft(E value);

    // добавить элемент справа
    boolean insertRight(E value);

    // удалить элемент слева
    E removeLeft();

    // удалить элемент справа
    E removeRight();

    // первый слева
    E peekFrontLeft();

    // первый справа
    E peekFrontRight();

    // размер дека
    int size();

    // пустой ли дек
    boolean isEmpty();

    // показать информацию о деке
    void display();

    // внутренний класс
    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next) {
            // поле для хранения данных
            this.item = item;
            // каждый элемент списка будет знать, кто следующий
            this.next = next;
        }
    }
}