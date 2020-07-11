package ru.progwards.java1.lessons.classes.figures;

import java.util.Arrays;

public abstract class Figure implements Comparable<Figure> {
    //реализация интерефейса AreaComparable
//    @Override
//    public int compareArea(Figure figure){
//        return Double.compare(this.area(),figure.area());
//    }
        @Override
    public int compareTo(Figure o){
        return Double.compare(this.area(),o.area());
    }

    //периметр фигуры
    abstract double perimeter();

    //площадь фигуры
    double area(){
        return 0d;
    }

//    @Override
//    public String toString(){
//        return "Абстрактная фигура";
//    }

    public static void  printInfo(Figure figure){
        System.out.println(figure);
        System.out.println("    периметр " + figure.perimeter());
        System.out.println("    площадь " + figure.area());
        System.out.println("");

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

