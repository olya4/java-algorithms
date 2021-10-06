package ru.geekbrains.homework1;

import java.util.Arrays;

// Удаление элемента массива с неизвестным индексом со сдвигом - O(n^3) полиномиальный рост
public class Task5 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(removeTheElementWithOutIndex(array, 2)));
    }

    public static int[] removeTheElementWithOutIndex(int[] arr, int element) {
        int[] newArr = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == element) {

                for (int k = 0; k < i; k++) {
                    newArr[k] = arr[k];
                }
                for (int j = i; j < arr.length - 1; j++) {
                    newArr[j] = arr[j + 1];
                }
                break;
            }
        }
        return newArr;
    }
}
