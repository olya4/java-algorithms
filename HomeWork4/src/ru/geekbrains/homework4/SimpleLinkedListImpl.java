package ru.geekbrains.homework4;

import java.util.Iterator;

// односвязный список
public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {
    // первый элемент списка
    protected Node<E> first;
    // размер списка
    protected int size;

    // добавление нового элемента в начало
    @Override
    public void insertFirst(E value) {
        // первый элемент будет равен новому узлу
        // соответственно тот эл-нт, который был до этого первым
        // сдвигается в право и становится вторым и т.д.

        // value - значение для созданного первого элемента
        // текущий first - следующий элемент для созданного первого элемента
        first = new Node<>(value, first);
        // увеличмть размер списка
        size++;
    }

    // удаление элемента с начала
    @Override
    public E removeFirst() {
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

    // удалить элемент по значению
    // взять элемент до удаляемого элемента и присвоить ему ссылку на следующий после удаляемого

    // 1(содержит ссылку на 2) -> 2(содержит ссылку на 3) -> 3(содержит ссылку на 4) -> 4
    // надо удалить 2
    // 1 (содержит ссылку на 3) -> 3(содержит ссылку на 4) -> 4
    // из-за того, что на 2 больше нет ссылок и сама 2 не содержит ссылок на следующий элемент - сборщик мусора сотрет ее

    @Override
    public boolean remove(E value) {
        // указатель на первый элемент
        Node<E> current = first;
        // указатель на предыдущий элемент
        Node<E> prev = null;

        // пройтись по всем элемнтам списка
        while (current != null) {
            // сравнить значение элемента из списка с заданным значением
            if (current.item.equals(value)) {
                // если элемент найден - выйти из цикла
                break;
            }
            // предыдущий элемент = current
            prev = current;
            // current = следующему элементу
            // если элемент не найден - перейти к следующему элементу по списку
            current = current.next;
        }

        // если элемент с искомым значением не найден в списке
        if (current == null) {
            return false;
            // если элемент с искомым значением лежит первым в списке
        } else if (current == first) {
            // вызвать метод - удаление элемента с начала
            removeFirst();
            return true;
        }
        // предыдущий элемент = следующему элементу
        // указатели препрыгнули через current (найденный элемент)
        // 1 теперь указвает на 3
        prev.next = current.next;
        // обнуление ссылки на следующий элемент у найденного элемента
        // 2 не содержит ссылок на следующий элемент
        current.next = null;
        // уменьшить размер списка
        size--;

        return true;
    }

    // входит ли элемент в список
    @Override
    public boolean contains(E value) {
        // указатель на первый элемент
        Node<E> current = first;
        // пройтись по всем элемнтам списка
        while (current != null) {
            // сравнить значение элемента из списка с заданным значением
            if (current.item.equals(value)) {
                return true;
            }
            // если элемент не найден - перейти к следующему элементу по списку
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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
                // добавить к выведенной строке стрелочку
                sb.append(" -> ");
            }
            // после прохождения цикла,
            // указатель перемещается на следующий элемент по списку
            current = current.next;
        }

        sb.append("]");

        return sb.toString();
    }

    // получить первый элемент из списка
    @Override
    public E getFirst() {
        // вернет значение первого элемента
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        // указатель на актуальный элемент
        private Node<E> current = first;

        // есть ли следующий элемент
        @Override
        public boolean hasNext() {
            // пока есть следующий элемент
            return current != null;
        }

        // получить следующий элемент
        @Override
        public E next() {
            // указатель на значение элемента
            E value = current.item;
            if (!hasNext()) {
                // указатель перемещается на следующий элемент по списку
                current = current.next;
            }
            //вернет значение элемента
            return value;
        }
    }
}



