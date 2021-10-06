package ru.geekbrains.homework1;

import java.util.Arrays;

// Удаление элемента массива с известным индексом без сдвига - O(n) линейный рост
public class Task3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(removeTheElementForIndex(array, 4)));
    }

    public static int[] removeTheElementForIndex(int[] arr, int index) {

        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                arr[i] = 0;
            }
        }
        return arr;
    }
}
