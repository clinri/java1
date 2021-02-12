package ru.progwards.java1.lessons.queues;

//Создать класс - очередь, на обслуживание заявок клиентов в зависимости от величины суммы заказа.
//2.1 Создать отдельный класс Order

import org.checkerframework.checker.units.qual.C;

import java.util.Comparator;
import java.util.PriorityQueue;

class Order {
    //2.2 Создать приватное свойство double sum  - сумма заказа
    private double sum;
    //2.3 Создать приватное свойство int num  - номер заказа
    private int num = 0;
    //2.4 Создать конструктор public Order(double sum) - для номера заказа
    // создать систему автонумерации, начиная с 1
    static int numAuto = 0;
    public Order(double sum){
        this.sum = sum;
        numAuto++;
        this.num = numAuto;
    }
    //2.5 Создать геттер public double getSum()
    public double getSum() {
        return sum;
    }
    //2.6 Создать геттер public int getNum()
    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Заказ " +
                "№ " + getNum() +
                ", на сумму " + getSum()+
                " руб.;";
    }
}
//Создать класс OrderQueue
//2.7 Создать метод, public void add(Order order), размещающий заказы в очередь с приоритетом, разбивая их по 3-м классам
//3 - заказы до 10000 руб включительно
//2 - заказы от 10000 до 20000 руб включительно
//1 - заказы от 20000 руб
public class OrderQueue  {
    private Comparator <Order> comparatorNum = new Comparator<>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Integer.compare(o1.getNum(), o2.getNum());
        }
    };
    private PriorityQueue <Order> numOrder1 = new PriorityQueue<>(comparatorNum);
    private PriorityQueue <Order> numOrder2 = new PriorityQueue<>(comparatorNum);
    private PriorityQueue <Order> numOrder3 = new PriorityQueue<>(comparatorNum);

    public void add(Order order){
        //добавляем заказ в очередь в зависимости от класса заказа
        if (order.getSum()>20_000)
            numOrder1.offer(order);
        else if (order.getSum()>10_000)
            numOrder2.offer(order);
        else
            numOrder3.offer(order);
    }

//2.8 Создать метод, public Order get(), возвращающий первый заказ в очереди для обслуживания.
// Вначале обслуживаются заказы класса 1, потом 2, потом 3. Внутри каждого класса заказы должны
// обслуживаться в порядке поступления (по номеру заказа). Метод не выбрасывает исключения,
// возвращает null в случае пустой очереди.
//
//Продумать, и, при необходимости, добавить в классы нужные методы и свойства, для того, чтобы реализовать эту задачу.
    public Order get(){
        //первой проверяется очередь с заказами класса 1
        if (!numOrder1.isEmpty())
            return numOrder1.poll();
        else if (!numOrder2.isEmpty())
            return numOrder2.poll();
        else
            return numOrder3.poll();
    }

    public static void main(String[] args) {
        Order order3 = new Order(100);
        Order order1 = new Order(20100);
        Order order2 = new Order(20200);
        Order order4 = new Order(200);
        Order order5 = new Order(10100);

        OrderQueue orderQueue = new OrderQueue();
        orderQueue.add(order1);
        orderQueue.add(order2);
        orderQueue.add(order3);
        orderQueue.add(order4);
        orderQueue.add(order5);

        Order element;
        while ((element = orderQueue.get()) != null){
            System.out.println(element.toString());
        }

    }

}