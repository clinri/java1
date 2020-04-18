package ru.progwards.java1.lessons.basics;

public class Astronomy{
    public static final double PI=3.14;
    public static final double R_EARTH= 6_371.2;
    public static final double R_MERCURY=2_439.7;
    public static final double R_JUPITER=71_492;
    public static void main(String[] args){
        double radius=1;
        System.out.println("площадь поверхности сферы радиуса r=" + radius + "км. => " + sphereSquare(radius) + "км. ");
        System.out.println("площадь поверхности Земли, имеющей радиус R=" + R_EARTH + "км. => " + earthSquare() + "км. ");
        System.out.println("площадь поверхности Меркурия, имеющей радиус R=" + R_MERCURY + "км. => " + mercurySquare() + "км. ");
        System.out.println("площадь поверхности Юпритера, имеющей радиус R=" + R_JUPITER + "км. => " + jupiterSquare() + "км. ");
        System.out.println("отношение площади поверхности Земли к площади поверхности Меркурия => " + earthVsMercury());
        System.out.println("отношение площади поверхности Земли к площади поверхности Юпитера => " + earthVsJupiter());
    }
    public static Double sphereSquare(Double r){ //площадь поверхности сферы радиуса r
        return 4*PI*r*r;
    }
    public static Double earthSquare(){ // площадь поверхности Земли
        return sphereSquare(R_EARTH);
    }
    public static Double mercurySquare(){ // площадь поверхности Меркурия
        return sphereSquare(R_MERCURY);
    }
    public static Double jupiterSquare(){ // площадь поверхности Юпитера
        return sphereSquare(R_JUPITER);
    }
    public static Double earthVsMercury(){ //отношение площади поверхности Земли к площади поверхности Меркурия
        return earthSquare()/mercurySquare();
    }
    public static Double earthVsJupiter(){ //отношение площади поверхности Земли к площади поверхности Юпритера
        return earthSquare()/jupiterSquare();
    }

}
