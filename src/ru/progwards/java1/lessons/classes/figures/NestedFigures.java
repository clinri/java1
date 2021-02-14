package ru.progwards.java1.lessons.classes.figures;

import java.util.Arrays;
import java.util.Objects;

public class NestedFigures {
    //вложенные классы-фигуры
    public abstract static class Figure implements Comparable<Figure> {
        //реализация интерефейса AreaComparable
        //    @Override
        //    public int compareArea(Figure figure){
        //        return Double.compare(this.area(),figure.area());
        //    }
        @Override
        public int compareTo(Figure o) {
            return Double.compare(this.area(), o.area());
        }

        //периметр фигуры
        abstract double perimeter();

        //площадь фигуры
        double area() {
            return 0d;
        }

        //    @Override
        //    public String toString(){
        //        return "Абстрактная фигура";
        //    }
    }

    public static class Segment extends Figure {
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

    public static class Square extends Segment { // квадрат
        Square(double a) {
            super(a);
        }

        @Override
        double area() {
            return a * a;
        }

        @Override
        double perimeter() {
            return 4 * a;
        }

        @Override
        public String toString() {
            return "Квадрат " + a + " х " + a;
        }
    }

    public final static class Triangle extends Segment {
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
            return "Треугольник со сторонами " + a + ", " + b + ", " + c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triangle triangle = (Triangle) o;
            return Double.compare(triangle.area(), this.area()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.area());
        }
    }

    public final static class Rectangle extends Square { //прямоугольник
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
            Rectangle rectangle = (Rectangle) o;
            return Double.compare(rectangle.area(), this.area()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.area());
        }
    }

    public final static class Circle extends Figure {
        double radius;

        Circle(double radius){
            this.radius=radius;
        }
        @Override
        double area(){
            return Math.PI*radius*radius;
        }
        @Override
        double perimeter(){
            return 2*Math.PI*radius;
        }
        @Override
        public String toString(){
            return "Окружность с радиусом " + radius;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Circle circle = (Circle) o;
            return Double.compare(circle.radius, radius) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(radius);
        }
    }

    //статические методы
    public static void printInfo(Figure figure) {
        System.out.println(figure);
        System.out.println("    периметр " + figure.perimeter());
        System.out.println("    площадь " + figure.area() + "\n");
    }

    public static void main(String[] args) {
        Segment segment=new Segment(5);
        Square square = new Square(5);
        Rectangle rectangle=new Rectangle(5,11);
        Circle circle=new Circle(5);
        Triangle triangle=new Triangle(3,4,5);

        Figure[] figures ={segment,square,rectangle,circle,triangle};
        Arrays.sort(figures);

        for (var figure: figures){
            printInfo(figure);
        }
//        printInfo(segment);
//        printInfo(square);
//        printInfo(rectangle);
//        printInfo(circle);
//        printInfo(triangle);

//        System.out.println("segment.compareArea(square)     = " + segment.compareArea(square));
//        System.out.println("square.compareArea(square)      = " + square.compareArea(square));
//        System.out.println("square.compareArea(rectangle)   = " + square.compareArea(rectangle));
//        System.out.println("circle.compareArea(triangle)    = " + circle.compareArea(triangle));
//        System.out.println("rectangle.compareArea(triangle) = " + rectangle.compareArea(triangle));

        System.out.println("segment.compareTo(square)     = " + segment.compareTo(square));
        System.out.println("square.compareTo(square)      = " + square.compareTo(square));
        System.out.println("square.compareTo(rectangle)   = " + square.compareTo(rectangle));
        System.out.println("circle.compareTo(triangle)    = " + circle.compareTo(triangle));
        System.out.println("rectangle.compareTo(triangle) = " + rectangle.compareTo(triangle));

    }
}
