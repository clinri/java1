package ru.progwards.java1.lessons.interfaces;

//Реализовать класс Hamster, потомок класса Animal, переопределяющий методы:
//1.6  public AnimalKind getKind(), который возвращает HAMSTER.
//1.7 public FoodKind getFoodKind(), который возвращает CORN
public class Hamster extends Animal {
    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }
    //2.4 Для класса Hamster, переопределить метод:
    //public double getFoodCoeff(), который должен возвращать 0.03

    @Override
    public double getFoodCoeff() {
        return 0.03;
    }
}
