package ru.progwards.clinri.T82;

//У класса Goat метод say() должен вернуть "Мее"
//У класса Goat метод eat() должен вернуть "Сено"
public class Goat implements Eating, Speaking {
    @Override
    public String eat() {
        return "Сено";
    }

    @Override
    public String say() {
        return "Мее";
    }

    public static void main(String[] args) {
        System.out.println(new Goat().eat());
        System.out.println(new Goat().say());
    }
}

