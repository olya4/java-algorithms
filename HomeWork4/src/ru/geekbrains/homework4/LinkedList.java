package ru.geekbrains.homework4;

public interface LinkedList<E> {

    // добавление нового элемента в начало
    void insertFirst(E value);

    // удаление элемента с начала
    E removeFirst();

    // удалить элемент по значению
    boolean remove(E value);

    // входит ли элемент в список
    boolean contains(E value);

    // размер списка
    int size();

    // пустой ли список
    boolean isEmpty();

    // показать содержимое списка
    void display();

    // получить первый элемент из списка
    E getFirst();

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

        public Node(E item, Node<E> next, Node<E> prev) {
            // значение элемента
            this.item = item;
            // ссылка на следующий элемент
            this.next = next;
            // ссылка на предыдущий элемент
            this.prev = prev;
        }
    }
}
