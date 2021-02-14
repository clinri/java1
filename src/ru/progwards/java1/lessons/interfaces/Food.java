package ru.progwards.java1.lessons.interfaces;
//3.5 Создать класс Food (еда), которое никак не связано иерархией наследования с Animal.
//3.6 В классе Food разместить приватную переменную int weight - вес еды в граммах, реализовать в классе конструктор, принимающий и устанавливающий значение веса.
//3.7 Реализовать метод public int getWeight(), возвращающий сохраненное значение веса.
//3.7 Для класса Food реализовать интерфейс CompareWeight..Сравнение сделать на основе веса еды.
//Метод CompareResult compareWeight должен возвращать
//Метод CompareResult compareWeight должен возвращать
//LESS если свой вес < веса параметра метода
//EQUAL если свой вес = веса параметра метода
//GREATER если свой вес > веса параметра метода

public class Food implements CompareWeight{
    int weight;
    public Food (int weight){
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food newFood = (Food) smthHasWeigt;
        switch (Double.compare(this.getWeight(), newFood.getWeight())) {
            case -1:
                return CompareResult.LESS;
            case 0:
                return CompareResult.EQUAL;
            case 1:
                return CompareResult.GREATER;
            default:
                return CompareResult.EQUAL;
        }
    }
}
