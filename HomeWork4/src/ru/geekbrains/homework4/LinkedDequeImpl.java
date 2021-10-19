package ru.geekbrains.homework4;

public class LinkedDequeImpl<E> implements Deque<E> {

    // первый элемент дека
    private Node<E> first;
    // последний элемент дека
    private Node<E> last;
    // размер списка
    private int size;

    // добавить элемент слева
    @Override
    public boolean insertLeft(E value) {
        // первый элемент будет равен новому узлу
        // соответственно тот эл-нт, который был до этого первым
        // сдвигается в право и становится вторым и т.д.

        // value - значение для созданного первого элемента
        // текущий first - следующий элемент для созданного первого элемента
        first = new Node<>(value, first);
        // увеличмть размер списка
        size++;

        if (size == 1) {
            // то последний = первому
            last = first;
        }

        return true;
    }

    // добавить элемент справа
    @Override
    public boolean insertRight(E value) {
        // создать узел нового нода = новый нод
        // (добавляемое значение, нет ссылки на следующий элемент, т.к. добавляется последний элемент)
        Node<E> newNode = new Node<>(value, null);

        // если список пустой
        if (isEmpty()) {
            // добавить как первый элемент
            insertLeft(value);
        }

        // 1(содержит ссылку на 2) -> 2(содержит ссылку на 3) -> 3(содержит ссылку на null)
        // newNode = 4

        // 1(содержит ссылку на 2) -> 2(содержит ссылку на 3) -> 3(содержит ссылку на newNode)
        last.next = newNode;
        // теперь последний = newNode
        // 1(содержит ссылку на 2) -> 2(содержит ссылку на 3) -> 3(содержит ссылку на 4) -> 4(содержит ссылку на null)
        last = newNode;
        // увеличить список
        size++;
        return true;
    }

    // удалить элемент слева
    @Override
    public E removeLeft() {
        // пустой ли список
        if (isEmpty()) {
            return null;
        }

        // Node<E> removerNode - переменная temp
        // временной переменной присваивается значение первого элемента
        Node<E> removerNode = first;
        // теперь первым элементом, будет следующий после предыдущего элемента
        first = removerNode.next;
        // обнуль ссылку у удаляемого элемента
        removerNode.next = null;
        // уменьшить размер списка
        size--;
        // вернуть значение удаленного элемента
        return removerNode.item;
    }

    // удалить элемент справа
    @Override
    public E removeRight() {
        // пустой ли список
        if (isEmpty()) {
            return null;
        }

        // Node<E> removerNode - переменная temp
        // временной переменной присваивается значение первого элемента
        Node<E> removerNode = last;
        // теперь первым элементом, будет следующий после предыдущего элемента
        last = removerNode.prev;
        // обнуль ссылку у удаляемого элемента
        removerNode.prev = null;
        // уменьшить размер списка
        size--;
        // вернуть значение удаленного элемента
        return removerNode.item;
    }

    // первый слева
    @Override
    public E peekFrontLeft() {
        return first.item;
    }

    // первый справа
    @Override
    public E peekFrontRight() {
        return last.item;
    }

    // размер дека
    @Override
    public int size() {
        return size;
    }

    // пустой ли дек
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // показать информацию о деке
    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        // указатель на актуальный элемент
        Node<E> current = first;
        // пройтийсь по всем элементам списка
        while (current != null) {
            // если значение следующего элемента не null,
            // добавить к выведенной строке элемент
            sb.append(current.item);
            // если у элемента есть следующий элемент
            if (current.next != null) {
                // добавить к выведенной строке пробел
                sb.append(" ");
            }
            // после прохождения цикла,
            // указатель перемещается на следующий элемент по списку
            current = current.next;
        }

        sb.append("]");

        return sb.toString();
    }
}
