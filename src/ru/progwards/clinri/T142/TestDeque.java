package ru.progwards.clinri.T142;

import java.util.ArrayDeque;

//Реализуйте метод с сигнатурой int sumLastAndFirst(ArrayDeque<Integer> deque)
// который возвращает сумму первого и последнего элемента очереди. При пустой очереди вернуть 0
public class TestDeque {
    int sumLastAndFirst(ArrayDeque<Integer> deque){
        if (deque.isEmpty()) return 0;
        return deque.peekFirst()+deque.peekLast();
    }
}
