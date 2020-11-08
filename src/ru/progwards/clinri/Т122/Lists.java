package ru.progwards.clinri.Т122;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Напишите метод, с сигнатурой public List<Integer> filter(List<Integer> list) который работает по следующему алгоритму
//
//суммирует значения всех элементов списка
//удаляет из списка элементы, значение которых больше суммы, деленной на 100 (целочисленное деление)
//возвращает результирующий список
public class Lists {
    public static List<Integer> filter(List<Integer> list) {
        int sum = 0;
        for (Integer i : list)
            sum += i;
        System.out.println(sum);

        sum /= 100;
        sum -= 1;
        System.out.println(sum);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > sum) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for (int i=0; i <= 50; i++){
            list.add(i);
        }
//        for (Integer i : list)
//            System.out.println(i);
//        list.add(1);
//        list.add(100);
//        list.add(400);
        for (Integer i : filter(list))
            System.out.println(i);
    }
}
