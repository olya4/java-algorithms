package ru.geekbrains.homework3.deque;

public class DequeImpl<E> implements Deque<E> {

    // хранилище дека
    private final E[] data;
    // размер дека
    private int size;

    // левая сторона
    private int left;
    // правая сторона
    private int right;

    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
    }

    // добавить элемент слева
    @Override
    public boolean insertLeft(E value) {
        // дек заполнен
        if (isFull()) {
            return false;
        }

        // перебор дека в обратном порядке
        for (left = size / 2; left >= 0; left--) {
            // сдвинуть все значения в право
            data[left + 1] = data[left];
        }

        data[left + 1] = value;

        // и размер массива увеличивается на единицу
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        // дек заполнен
        if (isFull()) {
            return false;
        }

        for (right = size / 2; right < size - 1; right++) {
            // сдвинуть все значения в право
            data[right + 1] = data[right];
        }

        data[right + 1] = value;

        // и размер массива увеличивается на единицу
        size++;
        return true;
    }

    // удалить элемент слева
    @Override
    public E removeLeft() {
        // если дек пустой
        if (isEmpty()) {
            return null;
        }

        // сохранить левую сторону и сдвинуть ее на следующий элемент
        E value = data[0];
        data[0] = data[1];
        // уменьшить размер дека
        size--;
        return value;
    }

    // удалить элемент справа
    @Override
    public E removeRight() {
        // если дек пустой
        if (isEmpty()) {
            return null;
        }
        // сохранить правую сторону и сдвинуть ее на следующий элемент
        E value = data[++right];
        // уменьшить размер дека
        size--;
        return value;
    }

    // ближайший первый слева
    @Override
    public E peekFrontLeft() {
        return data[0];
    }

    // ближайший первый справа
    @Override
    public E peekFrontRight() {
        return data[data.length - 1];
    }

    // размер дека
    @Override
    public int size() {
        // размер дека
        return size;
    }

    // пустой ли дек
    @Override
    public boolean isEmpty() {
        // сравнение размера с 0
        return size == 0;
    }

    // полный ли дек
    @Override
    public boolean isFull() {
        // сравнение размера с размером хранилища
        return size == data.length;
    }

    // показать содержимое дека
    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= size - 1; i++) {
            sb.append(data[i]);
            if (i >= 0) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
