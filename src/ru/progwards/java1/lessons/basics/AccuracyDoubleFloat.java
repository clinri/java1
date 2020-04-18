package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat{
    public static final double PI=3.14;
    public static final double R_EARTH= 6_371.2;
    public static void main(String[] args){ //разницу между значениями объёмов Земли вычисленных на основании типов double и float в кубических километрах
        System.out.println("Разницу между значениями объёмов Земли вычисленных на основании типов double и float: " + calculateAccuracy(R_EARTH) + " куб. км.");

    }
    public static double volumeBallDouble(double radius){ //объём Земли вычисленных на основании типа double в кубических километрах
        double doub1=4;
        double doub2=3;
        return doub1/doub2*PI*radius*radius*radius;
    }
    public static float volumeBallFloat(float radius){ //объём Земли вычисленных на основании типа float в кубических километрах
        float float1=4;
        float float2=3;
        return float1/float2*(float)PI*radius*radius*radius;
    }
    public static double calculateAccuracy(double radius){
        return volumeBallDouble(radius)-volumeBallFloat((float)radius);
    }
}
