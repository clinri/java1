package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int c = 9;
        System.out.println("возможность построить треуголник " + isTriangle(a, b, c));
        System.out.println("возможность построить прямоугольный треуголник " + isRightTriangle(a, b, c));
        System.out.println("возможность построить равнобедренный треуголник " + isIsoscelesTriangle(a, b, c));
    }

    public static boolean isTriangle(int a, int b, int c) { //возвращает true, если по данным трём сторонам (a, b, c) можно построить треугольник. Из геометрии известно, что в треугольнике длина каждой из сторон меньше суммы длин двух других сторон.
        boolean x = false;
        if (((a + b) > c) & ((a + c) > b) & ((c + b) > a)) x = true;
        return x;
    }
    public static boolean isRightTriangle(int a, int b, int c) { //возвращает true, если треугольник со сторонами a, b, c является прямоугольным. Из геометрии известно, что для прямоугольного треугольника выполняется теорема Пифагора (сумма квадратов катетов равна квадрату гипотенузы).
        boolean x = false;
        if (isTriangle(a, b, c) & (a * a + b * b == c * c | c * c + b * b == a * a | c * c + a * a == b * b)) x = true;
        return x;
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c) { // возвращает true, если треугольник со сторонами a, b, c является равнобедренным. Из геометрии известно, что в равнобедренном треугольнике есть две равные стороны.
        boolean x = false;
        if (isTriangle(a, b, c) & (a==b || a==c || b==c)) x=true;
        return x;
    }
}
