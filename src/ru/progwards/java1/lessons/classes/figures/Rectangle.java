package ru.progwards.java1.lessons.classes.figures;

import java.util.Objects;

public final class Rectangle extends Square { //прямоугольник
    double b;

    Rectangle(double a, double b){
        super(a);
        this.b=b;
    }

    @Override
    double area(){
        return a*b;

    }
    @Override
    double perimeter(){
        return 2*(a+b);
    }

    @Override
    public String toString(){
        return "Прямоугольник " + a + " х " + b;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.area(), this.area()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.area());
    }
}
