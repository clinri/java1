package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
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
        this.fiboCache = new HashMap<>();
    }

    //1.3 Реализовать public BigDecimal fiboNumber(int n). Алгоритм работы следующий:
    //в функции проверить, находится ли вычисленное значение для n в кэше,
    // и если да - вернуть его из кэша, если нет - рассчитать и добавить в кэш. Учитывать значение переменной cacheOn
    public BigDecimal fiboNumber(int n) {
        // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
        if (this.cacheOn & !this.fiboCache.isEmpty())
            if (this.fiboCache.containsKey(n))
                return this.fiboCache.get(n);
        BigDecimal fibo = new BigDecimal("0");
        BigDecimal onePastDigit = new BigDecimal("0");
        BigDecimal twoPastDigit = new BigDecimal("0");
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                fibo = new BigDecimal("1");
                twoPastDigit = new BigDecimal("1");
            }
            if (i == 2) {
                fibo = new BigDecimal("1");
                onePastDigit = new BigDecimal("1");
            }
            if (i > 2) {
                fibo = onePastDigit.add(twoPastDigit);
                twoPastDigit = onePastDigit;
                onePastDigit = fibo;
            }
        }
        if (this.cacheOn)
            this.fiboCache.put(n, fibo);
        return fibo;
    }

    //1.4 Реализовать метод public void clearCahe() который устанавливает переменную fiboCache в null
    public void clearCahe() {
        this.fiboCache = null;
    }

    //1.5 Для проверки работы реализовать public static void test() - тест для расчета чисел Фибоначчи
    // от n = 1 до 1000 включительно и замерить разницу во времени с on = true и on = false, результат
    // вывести на экран в формате "fiboNumber cacheOn=??? время выполнения ???" для cacheOn=true и cacheOn=false,
    // вместо ??? вывести реальные значения в мсек.
    public static void test() {
        long startTime;
        long endTime;
        boolean paramCacheBool = true;
        FiboMapCache myObj = new FiboMapCache(paramCacheBool);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i = i + 2) {
            myObj.fiboNumber(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("fiboNumber cacheOn=" + paramCacheBool + " время выполнения " + (endTime - startTime));

        paramCacheBool = false;
        myObj = new FiboMapCache(paramCacheBool);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i = i + 2) {
            myObj.fiboNumber(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("fiboNumber cacheOn=" + paramCacheBool + " время выполнения " + (endTime - startTime));
    }

    public static void main(String[] args) {
        test();

//        System.out.println(fiboNumber(6).toString());
//        for (int i=1; i<15; i++) {
//            System.out.println(fiboNumber(i).toString());
//        }

        // ===========

//        boolean paramCacheBool = true;
//        long startTime;
//        long endTime;
//        FiboMapCache myObj = new FiboMapCache(paramCacheBool);
//        startTime = System.currentTimeMillis();
//        for (int i =0; i<100; i=i+2) {
//            //System.out.println(myObj.fiboNumber(i).toString());
//            myObj.fiboNumber(i);
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);
//
//        startTime = System.currentTimeMillis();
//        for (int i =0; i<100; i=i+1) {
//            //System.out.println(myObj.fiboNumber(i).toString());
//            myObj.fiboNumber(i);
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);
//
//        startTime = System.currentTimeMillis();
//        for (int i =0; i<100; i=i+1) {
//            //System.out.println(myObj.fiboNumber(i).toString());
//            myObj.fiboNumber(i);
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);
//
//        for (Map.Entry<Integer, BigDecimal> entry: myObj.fiboCache.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }
//        myObj.clearCahe();

    }
}
