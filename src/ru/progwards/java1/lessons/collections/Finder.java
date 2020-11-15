package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Finder {
    // найти 2 соседних числа в коллекции сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        List<Integer> arrayListMinIndex = new ArrayList();
        List<Integer> arraySumList = new ArrayList();
        int i = 0;
        int num;
        int numNext;
        while (i < numbers.size() - 1) {
            num = (int) ((ArrayList) numbers).get(i);
            numNext = (int) ((ArrayList) numbers).get(i + 1);
            arraySumList.add(num + numNext);
            i++;
        }
        for (Integer intObj : arraySumList)
            System.out.println(intObj);
        System.out.println("==");
        Integer minNum = Collections.min(arraySumList);
        int minIndex = arraySumList.indexOf(minNum);
        arrayListMinIndex.add(minIndex);
        arrayListMinIndex.add(minIndex + 1);
        return arrayListMinIndex;
    }

    /*
    найти локальные максимумы - числа, которые больше соседа справа и слева.
    Первый и последний элемент коллекции не может являться локальным  максимумом,
    вернуть коллекцию, содержащую значения этих максимумов
     */
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        List<Integer> arrayListMaxIndex = new ArrayList();
        int num;
        int numNext;
        int numPrev;
        for (int i = 1; i < numbers.size() - 1; i++) {
            num = (int) ((ArrayList) numbers).get(i);
            numNext = (int) ((ArrayList) numbers).get(i + 1);
            numPrev = (int) ((ArrayList) numbers).get(i - 1);
            if (num > numPrev & num > numNext)
                arrayListMaxIndex.add(num);
        }
        return arrayListMaxIndex;
    }

    //проверить, содержит ли коллекция все числа от 1 до size(), порядок может быть произвольный
    public static boolean findSequence(Collection<Integer> numbers) {
        List<Integer> arrayListDigits = new ArrayList();
        for (int i = 1; i < numbers.size(); i++) {
            arrayListDigits.add(i);
        }
        for (Integer intObj : arrayListDigits)
            System.out.println(intObj);
        return numbers.containsAll(arrayListDigits);
    }

    /*
    найдите максимальное количество повторяющихся подряд элементов.
    Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
    При равенстве максимального количества у разных повторяющихся элементов,
    вернуть результат для элемента, повторяющаяся последовательность которого началась с наименьшего индекса.
     */
    public static String findSimilar(Collection<String> names) {
        List<Integer> arrayListRepeat = new ArrayList();
        for (int i=0;i<names.size();i++){
            arrayListRepeat.add(0);
        }
        int startIndexFind = 1;
        for (int i = 0; i < names.size()-1; i++) {
            if (((List) names).get(i).equals(((List) names).get(i + 1))) {
                startIndexFind++;
                arrayListRepeat.set(i, startIndexFind);
            } else {
                startIndexFind = 1;
            }
        }
        Integer countMax = Collections.max(arrayListRepeat);
        int indexCountVax = arrayListRepeat.indexOf(countMax);
        String nameCountMax = (String) ((List)names).get(indexCountVax);
        return nameCountMax+":"+countMax;
    }


    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }
        arrayList.set(1, 3);
        arrayList.add(4, 7);
        ((ArrayList) arrayList).trimToSize();
        for (Integer intObj : arrayList) {
            System.out.println(intObj);
        }
        System.out.println("==");
//        for (Integer intObj : findMinSumPair(arrayList)) {
//            System.out.println(intObj);
//        }
        for (Integer intObj : findLocalMax(arrayList)) {
            System.out.println(intObj);
        }
//        System.out.println(findSequence(arrayList));
//        List<String> arrayListString = new ArrayList();
//        arrayListString.add("Андрей");
//        arrayListString.add("Василий");
//        arrayListString.add("Евгений");
//        arrayListString.add("Евгений");
//        arrayListString.add("Евгений");
//        arrayListString.add("Василий");
//        arrayListString.add("Василий");
//        arrayListString.add("Василий");
//        arrayListString.add("Василий");
//
//        System.out.println(findSimilar(arrayListString));

    }
}
