package ru.progwards.clinri.T142;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

//Реализуйте метод с сигнатурой int sumLastAndFirst(ArrayDeque<Integer> deque)
// который возвращает сумму первого и последнего элемента очереди. При пустой очереди вернуть 0
public class TestDeque {
    int sumLastAndFirst(ArrayDeque<Integer> deque){
        if (deque.isEmpty()) return 0;
        return deque.peekFirst()+deque.peekLast();
    }

    static void dequeueTest() {
        ArrayDeque deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i%2 == 0)
                deque.poll();
        }

        System.out.println(deque);
    }

    static void pqTest() {
        PriorityQueue pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(1);
        pQueue.offer(9);
        pQueue.offer(3);
        System.out.println(pQueue);
    }

    public static void main(String[] args) {
        //dequeueTest();
        pqTest();
    }
}
