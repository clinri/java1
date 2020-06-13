package ru.progwards.clinri;

public class Т43 {
    public static void main(String[] args) {
        long n1=10;
        System.out.println("факториал " + n1 +"! : " + factorial(n1));
    }
    static long factorial(long n){ //факториал n это произведение всех чисел от 1 до n и факториал 0 == 1
        long x = 1;
        if (n==0) return 1;
        for (long i=1; i<=n; i++){
            x*=i;
        }
        return x;
    }
}