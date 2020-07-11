package ru.progwards.java1.lessons.classes.figures.triangle_test;

public class ConstructorTest {
    public static void main(String[] args) {
        class Parent{
            Parent(){
                System.out.println("Вызван констркутор Parent");
            }

        }
        class Child extends Parent{
            Child(){
                System.out.println("Вызван констркутор Child");
            }

        }

        new Child();

    }
}
