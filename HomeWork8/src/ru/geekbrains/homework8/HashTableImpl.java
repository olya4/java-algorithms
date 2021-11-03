package ru.geekbrains.homework8;

import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    // внутренний клас, реализующий внутренний интерфейс для пары
    static class Node<K, V> implements Entry<K, V> {
        // ключ (id)
        private K key;
        // значение (цена)
        private V value;
        // следующий
        private Node<K, V> next;
        // предыдущий
        private Node<K, V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        // вывод ключа и значения
        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    // массив связанных списков
    private ArrayList<Node<K, V>> array;
    // размер текущего количества элементов
    private int size;

    public HashTableImpl(int size) {
        this.size = size;
        // создание массива списков
        array = new ArrayList<Node<K, V>>();
        // заполнение массива листов списками
        for (int i = 0; i < size; i++) {
            // список заполняется null, чтоб массив был заданного размера
            array.add(null);
        }
    }

    // добавить пару (ключ, значение)
    @Override
    public boolean put(K key, V value) {

        Node<K, V> node = getNodeForKey(key);

        if (node != null) {
            node.value = value;
            return true;
        }

        node = new Node<K, V>(key, value);

        int index = hashFunc(key);

        if (array.get(index) != null) {
            node.next = array.get(index);
            node.next.prev = node;
        }
        array.set(index, node);

        return true;
    }


    // узел связного списка для заданного ключа
    private Node<K, V> getNodeForKey(K key) {

        int index = hashFunc(key);

        Node<K, V> current = array.get(index);

        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // хэш-функция ключа
    private int hashFunc(K key) {
        // хэш-код ключа делится на длину массива, чтобы оставаться в рамках массива
        // Math.abs - взять число по модулю (все числа будут положительные)
        return Math.abs(key.hashCode()) % array.size();
    }

    // вернуть значение по ключу
    @Override
    public V get(K key) {

        if (key == null) {
            return null;
        }

        Node<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    // удалить значение по ключу
    @Override
    public V remove(K key) {

        Node<K, V> node = getNodeForKey(key);

        if (node == null) {
            return null;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int hashKey = hashFunc(key);
            array.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        return node.value;
    }

    // размер текущего количества элементов
    @Override
    public int size() {
        return size;
    }

    // пуста ли хэш-таблица
    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    // вывод
    @Override
    public void display() {
        System.out.println("--------------------------");
        for (int i = 0; i < array.size(); i++) {
            String s = array.get(i) == null ? "" : array.get(i).toString();
            System.out.println(i + ": " + s);
        }
        System.out.println("--------------------------");
    }
}