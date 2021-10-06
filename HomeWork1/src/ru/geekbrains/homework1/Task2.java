package ru.geekbrains.homework1;

import java.util.Arrays;

// Дублирование одномерного массива через foreach - O(n) линейный рост
public class Task2 {
    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D"};
        String[] copy = new String[array.length];

        for (String i : array) {
            copy = array;
        }
        System.out.println(Arrays.toString(copy));
    }
}
