package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

//Реализовать класс SetOperations, операции над множествами целых чисел.
public class SetOperations {

    //1.1 Метод public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) - объединение множеств
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        return result;
    }

    //1.2 Метод public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) - пересечение множеств
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        HashSet result = new HashSet(set1);
        result.retainAll(set2);
        return result;
    }

    //1.3 Метод public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) - разница множеств
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2){
        HashSet result = new HashSet(set1);
        result.removeAll(set2);
        return result;
    }

    //1.4 Метод public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) - симметрическая разница
    //Кто подзабыл что значит каждая операция,
    // можно глянуть тут https://studopedia.ru/14_138615_operatsii-nad-mnozhestvami-i-ih-svoystva.html или OK - google
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){
        Set unionSet = new HashSet(set1); // множество для объединенного множества
        unionSet =  union(set1, set2);
        Set intersectionSet = new HashSet(set1); // множество для пересеченного множества
        intersectionSet = intersection(set1,set2);
        Set result = new HashSet(unionSet); // множество для симметричной разницы множеств
        result.removeAll(intersectionSet);
        return result;
    }
}
