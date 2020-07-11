package ru.progwards.clinri.T82;

//У класса Dog метод say() должен вернуть "Гав"
//У класса Dog метод eat() должен вернуть "Мясо"
public class Dog implements Eating, Speaking {
    @Override
    public String eat() {
        return "Мясо";
    }

    @Override
    public String say() {
        return "Гав";
    }

    public static void main(String[] args) {
        System.out.println(new Dog().eat());
        System.out.println(new Dog().say());
    }
}
