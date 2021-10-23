package ru.geekbrains.homework5;

public class DegreeNumber {

    private static int exponentiationOfNumber(int number, int degree) {
        if (degree == 0) {
            return 1;
        }
        if (degree == 1) {
            return number;
        }

        return (number * exponentiationOfNumber(number, degree - 1));

    }

    public static void main(String[] args) {
        System.out.println(exponentiationOfNumber(2, 5));
    }
}
