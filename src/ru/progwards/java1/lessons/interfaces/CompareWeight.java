package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {
//    //Метод CompareResult compareWeight должен возвращать
//    //LESS если свой вес < веса параметра метода
//    //EQUAL если свой вес = веса параметра метода
//    //GREATER если свой вес > веса параметра метода
    public enum CompareResult{
        LESS,
        EQUAL,
        GREATER
    }
    public CompareResult compareWeight(CompareWeight smthHasWeigt);

    //3.8 Скопировать реализацию сортировки из класса ArraySort из задачи 2 урока 6 и переделать сортировку
    // массива целых чисел на сортировку через интерфейс CompareWeight public static void sort(CompareWeight[] a)
    public static void sort(CompareWeight[] a){
        CompareWeight memory;
        for (int i=0; i<a.length; i++){
            for (int j=i+1; j<a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareResult.GREATER){
                    memory=a[i];
                    a[i]=a[j];
                    a[j]=memory;
                }
            }
        }
    }
}
