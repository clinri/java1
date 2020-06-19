package ru.progwards.java1.lessons.interfaces;
//Задача 2. Класс CalculateFibonacci
//Задача на динамическое программирование. Это когда некоторые результаты сохраняются для последующего использования.
//Для функции public static int fiboNumber(int n) из задачи 3 урока 4 сделать сохранение одного, последнего
// из рассчитанных значений. Для этого:
/*
2.1 Разместить в классе CalculateFibonacci функцию
public static int fiboNumber(int n)
*/
/*
2.2 Разместить вложенный класс
public static class CacheInfo, содержащий пару свойств:
    public int n - число, для которого рассчитываем Фибоначчи
    public int fibo - результат расчета
*/
//2.3 Разместить в классе CalculateFibonacci приватную статическую переменную CacheInfo lastFibo;
//
//2.4 В статической функции fiboNumber, проверять параметр n на совпадение с последним рассчитанным значением,
// и если совпадает - возвращать уже готовый результат. Если не совпадает - рассчитывать и сохранять
// в статической переменной lastFibo.
//
//2.5 Реализовать метод public static CacheInfo getLastFibo() который возвращает lastFibo
//
//2.6 Реализовать метод public static void clearLastFibo(), который сбрасывает lastFibo в null

public class CalculateFibonacci {
    private static CacheInfo lastFibo = new CacheInfo();

    //2.4 В статической функции fiboNumber, проверять параметр n на совпадение с последним рассчитанным значением,
    // и если совпадает - возвращать уже готовый результат. Если не совпадает - рассчитывать и сохранять
    // в статической переменной lastFibo.
    public static int fiboNumber(int n){
        if (lastFibo.n == n) return lastFibo.fibo;
        lastFibo.n = n;
        int calcFibo=0;
        int sumTwoPastDigit=0;
        int onePastDigit=0;
        int twoPastDigit=0;
        for (int i=1; i<=n;i++){
            if (i==1){
                calcFibo = 1;
                twoPastDigit=1;
            }
            if (i==2){
                calcFibo = 1;
                onePastDigit=1;
            }
            if (i>2){
//                System.out.print("предыдущие 2 числа " + twoPastDigit + " " + onePastDigit);
                calcFibo=onePastDigit+twoPastDigit;
                twoPastDigit=onePastDigit;
                onePastDigit=calcFibo;
            }
//            System.out.println(", а " + i + "-е число фибо = " + fibo); // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        }
        lastFibo.fibo=calcFibo;
        return calcFibo;
    }
    //2.5 Реализовать метод public static CacheInfo getLastFibo() который возвращает lastFibo
    public static CacheInfo getLastFibo(){
        return lastFibo;
    }

    public static void clearLastFibo(){
        lastFibo=null;
    }

    public static class CacheInfo{
        public int n;
        public int fibo;
    }

    public static void main(String[] args) {

        System.out.println(lastFibo.n +" " + lastFibo.fibo);
        System.out.println(fiboNumber(7));
        System.out.println(lastFibo.n +" " + lastFibo.fibo);
        clearLastFibo();
        fiboNumber(29);
        //System.out.println(lastFibo.n +" " + lastFibo.fibo);




    }
}
