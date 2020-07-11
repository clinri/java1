package ru.progwards.java1.lessons.bigints;

import com.google.inject.internal.cglib.core.$VisibilityPredicate;

import java.math.BigDecimal;
import java.math.BigInteger;

//Реализовать алгоритм быстрого возведения в степень pow числа num в BigDecimal,
// описание алгоритма можно прочитать например в Википедии

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow) {
        int pTest = pow;
        int k = 0;
        while (pTest != 0) {
            k++;
            pTest >>>= 1;
        }
        System.out.println("двоичная длина pow " + k);
        BigDecimal rezult = BigDecimal.ONE;
        BigDecimal numK;
        for (int i = k; i > 0; i--) {
            numK = BigDecimal.ONE;
            pTest = pow >>> i - 1;
            if ((pTest & 1) == 1) numK = num;
            rezult = rezult.multiply(numK);
            if (i != 1) rezult = rezult.multiply(rezult);
        }
        return rezult;
    }

    static BigInteger fibonacci(int n) {
        BigInteger fibo = BigInteger.ZERO;
        BigInteger sumTwoPastDigit = BigInteger.ZERO;
        BigInteger onePastDigit = BigInteger.ZERO;
        BigInteger twoPastDigit = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                fibo = BigInteger.ONE;
                twoPastDigit = BigInteger.ONE;
            }
            if (i == 2) {
                fibo = BigInteger.ONE;
                onePastDigit = BigInteger.ONE;
            }
            if (i > 2) {
//                System.out.print("предыдущие 2 числа " + twoPastDigit + " " + onePastDigit);
                fibo = onePastDigit.add(twoPastDigit);
                twoPastDigit = onePastDigit;
                onePastDigit = fibo;
            }
//            System.out.println(", а " + i + "-е число фибо = " + fibo); // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        }
        return fibo;
    }

/*
возвращать n-ое число Фибоначчи (нумерация начинается с 1, то есть при n = 3 должно вернуться число Фибоначчи 2,
а при n = 10 число 55)
 */

    public static void main(String[] args) {
        BigDecimal numBig = new BigDecimal("55");
        int powBig = 36;
        System.out.println(fastPow(numBig, powBig));

        System.out.println(fibonacci(7));

    }
}