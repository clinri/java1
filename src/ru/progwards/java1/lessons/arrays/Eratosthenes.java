package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

//        1.1 Реализовать класс Eratosthenes, содержащий:
//        массив чисел, собственно, "решето"
//private boolean[] sieve, для того, чтобы узнать, я является ли число n простым, нужно взять значение по индексу в массиве. sieve[n]. Значение true, означает простое число, false - составное.
//        1.2 Реализовать конструктор
//public Eratosthenes(int N), который должен разместить массив sieve с размером в N и заполнить его значениями true, после чего вызвать метод sift()
//        1.3 Реализовать метод
//private void sift(), который, собственно и реализует алгоритм Эратосфена, просеивая составные числа.
//        Подсказка - нужно реализовать 2 вложенных цикла, внешний, например по i от 2 до N-1, и внутренний, например по j который будет просеивать числа, кратные переменной внешнего цикла i*j.
//        1.4 Реализовать метод
//public boolean isSimple(int n), который возвращает sieve[n], что бы можно было узнать, простое число n или составное
public class Eratosthenes {
    private boolean[] sieve;
//взять значение по индексу в массиве. sieve[n]. Значение true, означает простое число, false - составное.
    public Eratosthenes(int N){
        //конструктор размеoщающий массив sieve с размером в N и заполнить его значениями true, после чего вызвать метод sift()
        sieve = new boolean[N];
        Arrays.fill(sieve,true);
        sift();
    }
    private void sift(){
        //реализует алгоритм Эратосфена, просеивая составные числа
        //подсказка - нужно реализовать 2 вложенных цикла, внешний, например по i от 2 до N-1,
        // и внутренний, например по j который будет просеивать числа, кратные переменной внешнего цикла i*j.
        for (int i=2; i < sieve.length; i++) {
            for (int j=2; i*j < sieve.length; j++){
                sieve[i*j]=false;
            }
        }
    }
    public boolean isSimple(int n){ //возвращает значение элемента sieve[n], что бы можно было узнать, простое (true) число n или составное (false)
        return sieve[n];
    }

    public static void main(String[] args) {
        System.out.println(new Eratosthenes(100).isSimple(11));
    }
}
