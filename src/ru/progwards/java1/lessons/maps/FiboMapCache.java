package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.Map;

public class FiboMapCache {
    // Кеш для чисел Фибоначчи на Map. Кеш имитирует таковой на сервере,
    // когда идут запросы со случайными параметрами от разных пользователей.
    // Сам алгоритм чисел Фибоначчи - это просто пример некоего алгоритма, который долго работает,
    // в сравнении с вытаскиванием значения из кэша. Считается, что кеш ничего не знает об алгоритме,
    // и умеет только сохранять и доставать значения по ключу.

    //1.1 Определить приватную локальную переменную fiboCache как Map<Integer, BigDecimal>
    private Map<Integer, BigDecimal> fiboCache;
    boolean cacheOn;

    // 1.2 Определить конструктор public FiboMapCache(boolean cacheOn) - включен ли кэш.
    // При cacheOn = true кэш работает, при cacheOn = false - выключен
    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
    }

    //1.3 Реализовать public BigDecimal fiboNumber(int n). Алгоритм работы следующий:
    //в функции проверить, находится ли вычисленное значение для n в кэше,
    // и если да - вернуть его из кэша, если нет - рассчитать и добавить в кэш. Учитывать значение переменной cacheOn
    public static BigDecimal fiboNumber(int n) {
        BigDecimal fibo = new BigDecimal(0);
        BigDecimal sumTwoPastDigit = new BigDecimal(0);
        BigDecimal onePastDigit = new BigDecimal(0);
        BigDecimal twoPastDigit = new BigDecimal(0);
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                fibo = new BigDecimal(0);
                twoPastDigit = new BigDecimal("1");
            }
            if (i == 2) {
                fibo = new BigDecimal("1");
                onePastDigit = new BigDecimal("1");
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

    public static void main(String[] args) {
        System.out.println(fiboNumber(1).toString());
//        for (int i=1; i<10; i++) {
//            System.out.println(fiboNumber(i).toString());
//        }
    }
}
