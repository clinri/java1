package ru.progwards.clinri.T123;
/*
Напишите метод с сигнатурой public void iterator3(ListIterator<Integer> iterator)
который заменяет значение каждого элемента, которое кратно 3 на значение его индекса.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class testIterators {
    public static void iterator3(ListIterator<Integer> iterator){
        while (iterator.hasNext()){
            Integer intObj = iterator.next();
            if (intObj%3==0){
                iterator.set(iterator.nextIndex()-1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList();
        for (int i=0; i<11;i++){
            linkedList.add(i+1);
        }
        ListIterator<Integer> listIterator = linkedList.listIterator();
        for (Integer intObj : linkedList){
            System.out.println(intObj);
        }
        System.out.println("===");
        iterator3(listIterator);
        for (Integer intObj : linkedList){
            System.out.println(intObj);
        }
        Iterator<Integer> listIterator1 = linkedList.iterator();
    }

}
