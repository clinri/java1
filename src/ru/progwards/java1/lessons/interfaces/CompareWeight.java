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

}
