package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Creator {
    /*
    создать коллекцию и заполнить последовательностью четных возрастающих чисел начиная с 2,
    количество элементов в коллекции n
     */
    public static Collection<Integer> fillEven(int n) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < n; i++) {
            arrayList.add((i + 1) * 2);
            System.out.println((i + 1) * 2);
        }
        System.out.println("==");
        return arrayList;
    }

    /*
    создать коллекцию и заполнить последовательностью нечетных убывающих чисел,
    минимальное число в коллекции 1, количество элементов в коллекции n
     */
    public static Collection<Integer> fillOdd(int n) {
        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            ((LinkedList<Integer>) linkedList).push(i * 2 + 1);
            System.out.println(i * 2 + 1);
        }
        System.out.println("==");
        return linkedList;
    }

    /*
    создать коллекцию и заполнить ее тройками чисел. Каждая тройка создается по алгоритму:
    первое число тройки - индекс числа в коллекции, второе - индекс в квадрате,
    третье - индекс в кубе, количество элементов в коллекции n*3
     */
    public static Collection<Integer> fill3(int n) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 3 * n; i += 3) {
            arrayList.add(i);
            arrayList.add(i * i);
            arrayList.add(i * i * i);
        }


        return arrayList;
    }

    public static void main(String[] args) {
//        for (Integer intObj : fillEven(3))
//            System.out.println(intObj);
//        for (Integer intObj : fillOdd(3))
//            System.out.println(intObj);
        for (Integer intObj : fill3(3))
            System.out.println(intObj);
    }
}
