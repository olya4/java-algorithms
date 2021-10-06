package ru.geekbrains.homework1;

// Поиск элемента массива с известным индексом - O(n) линейный рост
public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(foundElement(array, 2));
    }

    public static int foundElement(int[] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                return arr[i];
            }
        }
        return -1;
    }
}
