package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static void main(String[] args){
        int a=3;
        int b=3;
        int c=3;
        System.out.println("максимальная длина сторон треугольника " +maxSide(a,b,c));
        System.out.println("минимальная длина сторон треугольника " +minSide(a,b,c));
        System.out.println("треугольник равносторонний " +isEquilateralTriangle(a,b,c));
    }
    public static int maxSide(int a, int b, int c){ //получает параметрами длины сторон треугольника, а возвращает наибольшую длину стороны
        int x=0;
        if (a==b & a==c) x=a;
        if (a>b & a>c | a==b & a>c | a==c & a>b) x = a;
        if (b>a & b>c | b==a & b>c | b==c & b>a) x = b;
        if (c>a & c>b | c==a & c>b | c==b & c>a) x = c;
        return x;
    }
    public static int minSide(int a, int b, int c){ //получает параметрами длины сторон треугольника, а вернуть должна наименьшую длину стороны
        int x=0;
        if (a==b & a==c) x=a;
        if (a<b & a<c | a==b & a<c | a==c & a<b) x = a;
        if (b<a & b<c | b==a & b<c | b==c & b<a) x = b;
        if (c<a & c<b | c==a & c<b | c==b & c<a) x = c;
        return x;
    }
    public static boolean isEquilateralTriangle(int a, int b, int c){ //получает параметрами длины сторон треугольника, а вернуть должна true, если треугольник равносторонний и false в противном случае
        boolean x=false;
        if (a==b & a==c) x=true;
        return x;
    }
}
