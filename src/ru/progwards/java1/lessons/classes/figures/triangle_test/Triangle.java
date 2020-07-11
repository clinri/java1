package ru.progwards.java1.lessons.classes.figures.triangle_test;

public class Triangle {
    //свойства
    private double a, b, c;
    public boolean isOK = false;

    //конструктор
    public Triangle(){
        isOK=a+b>c && a+c>b && b+c>a;
    }

    public Triangle(double a, double b, double c){
        this();
        this.a=a;
        this.b=b;
        this.c=c;
    }

    //методы
    public double perimeter(){
        return a+b+c;
    }

    public double area(){
        //считаем по формуле Герона
        double hP=perimeter()/2;
        return Math.sqrt(hP*(hP-a)*(hP-b)*(hP-c));
    }
}
