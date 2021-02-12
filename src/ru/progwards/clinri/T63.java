package ru.progwards.clinri;

import java.util.Arrays;

public class T63 {
//    Реализуйте функцию, возвращающую максимальный по значению элемент массива. Если в массиве 0 элементов, вернуть 0. Сигнатура функции
//    public int arrayMax(int[] a)
//    Подсказка - для быстрой реализации удобно использовать функцию Arrays.sort()
    public static int arrayMax(int[] a){
        if (a.length == 0) {
            return 0;
        } else {
            Arrays.sort(a);
            return a[a.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] array1= new int[1];
        System.out.println(arrayMax(array1));
    }


}
