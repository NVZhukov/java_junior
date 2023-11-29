package ru.geekbrains.hw1;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    /*
        Напишите программу, которая использует Stream API для обработки списка чисел.
        Программа должна вывести на экран среднее значение всех четных чисел в списке.
     */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> list1 = Arrays.asList(1, 21, 3, 43, 5, 61, 7, 81, 9);

        System.out.println(getEvenAverage(list1));
    }

    public static double getEvenAverage(List<Integer> list) {
        return list.stream()
                .filter(a -> a % 2 == 0)
                .mapToInt(a -> a)
                .average().orElse(0);
    }
}
