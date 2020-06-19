package ru.progwards.java1.lessons.interfaces;

public class ArraySort  {
    //3.8 Скопировать реализацию сортировки из класса ArraySort из задачи 2 урока 6 и переделать сортировку

    public static void sort(CompareWeight[] a){
        CompareWeight memory;
        for (int i=0; i<a.length; i++){
            for (int j=i+1; j<a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareWeight.CompareResult.GREATER){
                    memory=a[i];
                    a[i]=a[j];
                    a[j]=memory;
                }
            }
        }
    }
}
