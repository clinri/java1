package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort implements Comparable<CollectionsSort> {
    //Сравнение методов сортировки коллекций
    //1.1 Реализовать метод public static void mySort(Collection<Integer> data) - переделать алгоритм из
    // класса ArraySort из ДЗ про массивы, на коллекции. Не использовать встроенные методы сортировок
    public static void mySort(Collection<Integer> data){
        System.out.println("data" + data);
        ArrayList<Integer> arrListData = (ArrayList) data;
        ////1. Берем первый элемент и сравниваем его со вторым, если второй меньше, меняем элементы в массиве местами.
        ////2. Далее, сравниваем первый элемент с третьим, и если третий меньше, меняем их местами.
        ////3. Так делаем для всех элементов с индексом больше первого
        ////4. Берем второй элемент и сравниваем его с третьим, если нужно, меняем местам
        ////5. Далее сравниваем второй элемент с четвертым, и если нужно, меняем местами.
        ////6. Делаем так для всех элементов, с индексом больше 2-го
        ////7. Переходим к элементу с индексом 3...
        ////8. Обобщая, алгоритм звучит следующим образом - сделать 2 вложенных цикла,
        //// внешний по i и внутренний по j. Внутренний цикл начинается от i+1, и если a[i] > a[j],
        // то нужно поменять элементы a[i] и a[j] местами.
        Integer memory;
        for (int i=0; i<arrListData.size()-1; i++){
            for (int j=i+1; j<arrListData.size(); j++) {
                if ((int)arrListData.get(i)>(int)arrListData.get(j)){ //сравниваем предыдущий и следующий элемент.
                    memory = (Integer) arrListData.get(i); //если второй больше, то меняем элементы местами
                    arrListData.set(i,arrListData.get(j));
                    arrListData.set(j,memory);
                }
            }
        }
        //System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
        System.out.println("mySort" + arrListData);
    }
    //1.2 Реализовать метод public static void minSort(Collection<Integer> data) по следующему алгоритму
    //- создать новую коллекцию
    //- найти минимальный элемент с использованием функции min()
    //- переместить его в новую коллекцию
    //- делать так до тех пор, пока все элементы не окажутся в новой коллекции
    //- скопировать новую коллекцию в старую
    public static void minSort(Collection<Integer> data){
        Collection<Integer> collect = new ArrayList();
        Integer intMinObj = 0;
        while (!data.isEmpty()){
            intMinObj = Collections.min(data);
            collect.add(intMinObj);
            data.remove(intMinObj);
        }
        data.addAll(collect);
    }

    //1.3 Реализовать метод public static void collSort(Collection<Integer> data) используя метод sort из Collections
    public static void collSort(Collection<Integer> data){
        Collections.sort((List)data);
    }

    String nameMethod = "";
    Long timeWork = 0l;

    public CollectionsSort (String nameMethod, Long timeWork){
        this.nameMethod = nameMethod;
        this.timeWork = timeWork;
    }

    @Override
    public int compareTo(CollectionsSort o) {
        //В случае равенства производительности каких-то методов,
        // возвращать их названия в алфавитном порядке
        int compareTime = Long.compare(timeWork,o.timeWork);
        if (compareTime == 0)
            return nameMethod.compareTo(o.nameMethod);
        else return compareTime;
    }

    //1.4 Реализовать метод public static Collection<String> compareSort() в котором сравнить
    // производительность методов и вернуть их имена, отсортированные в порядке производительности,
    // первый - самый быстрый. В случае равенства производительности каких-то методов,
    // возвращать их названия в алфавитном порядке.
    static final int ELEMENTS_COUNT = 1_000;

    public static Collection<String> compareSort(){
        List<Integer> testArrayList = new ArrayList();
        for (int i=ELEMENTS_COUNT; i>0; i--){
            testArrayList.add(i);
        }
        TreeSet <CollectionsSort> treeSet = new TreeSet();
        long startTime = System.currentTimeMillis();
        mySort(testArrayList);
        long endTime = System.currentTimeMillis();
        treeSet.add(new CollectionsSort("mySort",endTime - startTime));
        System.out.println("mySort: " + (endTime - startTime));
        //

        startTime = System.currentTimeMillis();
        minSort(testArrayList);
        endTime = System.currentTimeMillis();
        treeSet.add(new CollectionsSort("minSort",endTime - startTime));
        System.out.println("minSort: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        collSort(testArrayList);
        endTime = System.currentTimeMillis();
        treeSet.add(new CollectionsSort("colSort",endTime - startTime));
        System.out.println("colSort: " + (endTime - startTime));
        ArrayList<String> arrListSortNames = new ArrayList<>();
        for (CollectionsSort obj: treeSet)
            arrListSortNames.add(obj.nameMethod);
        return arrListSortNames;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, 8,2,5,3,1,0);
        System.out.println(arrayList);
        mySort(arrayList);
        System.out.println(arrayList);
        System.out.println(compareSort());
    }
}
