package ru.progwards.java1.lessons.classes.figures;

import java.util.Objects;

public class Segment extends Figure{
    double a; //свойство

    Segment(double a){ // конструктор
        this.a=a;
    }

    @Override
    double perimeter(){
        return a;
    }

    @Override
    public String toString(){
        return "Отрезок, длинна " + a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Double.compare(segment.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }
}