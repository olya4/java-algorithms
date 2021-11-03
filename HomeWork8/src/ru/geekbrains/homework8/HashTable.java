package ru.geekbrains.homework8;

public interface HashTable<K, V> {

    // добавить пару (ключ, значение)
    boolean put(K key, V value);

    // вернуть значение по ключу
    V get(K key);

    // удалить значение по ключу
    V remove(K key);

    // размер текущего количества элементов
    int size();

    // пуста ли хэш-таблица
    boolean isEmpty();

    // вывод
    void display();

    // внутренний интерфейс для пары
    interface Entry<K, V> {
        // ключ
        K getKey();

        // значение
        V getValue();

        // если такой ключ уже существует - обновить значение
        void setValue(V value);
    }

}
