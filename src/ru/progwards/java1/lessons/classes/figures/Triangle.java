package ru.progwards.java1.lessons.classes.figures;

import java.util.Objects;

public final class Triangle extends Segment{
    double b;
    double c;

    Triangle(double a, double b, double c){
        super(a);
        this.b=b;
        this.c=c;

    }
    @Override
    double area(){
        //считаем по формуле Герона
        double hP=perimeter()/2;
        return Math.sqrt(hP*(hP-a)*(hP-b)*(hP-c));
    }
    @Override
    double perimeter(){
        return a+b+c;
    }
    @Override
    public String toString(){
        return "Треугольник состоронами " + a + ", " + b + ", " + c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.area(), this.area()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.area());
    }
}
