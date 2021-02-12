package ru.progwards.clinri.T141;

import java.util.ArrayDeque;

public class TestArrayDeque {
    ArrayDeque<Integer> array2queue(int[] a) {
        ArrayDeque<Integer> arrDequeInt = new ArrayDeque();
        for (int i = 0; i < a.length; i++) {
            arrDequeInt.offer(a[i]);
        }
        return arrDequeInt;
    }
}
