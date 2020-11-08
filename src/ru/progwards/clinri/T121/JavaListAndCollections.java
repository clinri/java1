package ru.progwards.clinri.T121;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//Напишите метод с сигнатурой public List<Integer> listAction(List<Integer> list), который выполняет следующие действия:
//
//удаляет минимальный элемент коллекции
//по индексу 0 добавляет число равное количеству элементов
//по индексу 2 добавляет максимальный элемент из list
//возвращает list как результат метода

public class JavaListAndCollections {
    public static List<Integer> listAction(List<Integer> list){
        list.remove(Collections.min(list));
        list.add(0,list.size());
        list.add(2,Collections.max(list));
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        listAction(list);
        for (Integer i : list){
            System.out.println(i);
        }

    }
}
