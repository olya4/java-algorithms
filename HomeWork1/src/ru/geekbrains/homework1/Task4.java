package ru.geekbrains.homework1;

import java.util.Arrays;

// Удаление элемента массива с неизвестным индексом без сдвига - O(n) линейный рост
public class Task4 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(removeTheElementWithOutIndex(array, 2)));
    }

    public static int[] removeTheElementWithOutIndex(int[] arr, int element) {
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == element) {
                arr[i] = 0;
            }
        }
        return arr;
    }
}
