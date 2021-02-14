package ru.progwards.java1.lessons.classes.figures.triangle_test;

public class UseOfTriangle {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3,4,5);
        Triangle triangle2 = new Triangle(5,5,5);
        Triangle triangle3 = new Triangle(5,3,5);
        System.out.println("периметр triangle1 = " + triangle1.perimeter());
        System.out.println("периметр triangle1 = " + triangle1.area());

        System.out.println("периметр triangle2 = " + triangle2.perimeter());
        System.out.println("периметр triangle2 = " + triangle2.area());

        System.out.println("периметр triangle3 = " + triangle3.perimeter());
        System.out.println("периметр triangle3 = " + triangle3.area());

        boolean isOK = triangle1.isOK;
        //boolean a = triangle1.a; // a приватное свойство

    }
}
