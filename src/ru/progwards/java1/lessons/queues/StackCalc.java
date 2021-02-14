package ru.progwards.java1.lessons.queues;
//Стековый калькулятор (есть даже такой стековый язык программирования - Forth). Стек, это структура данных, работающая
// по принципу LIFO - last in first out (последний вошедший выходит первый), это противоположность привычной очереди
// FIFO - first in first out - первый вошедший выходит первый

import java.util.ArrayDeque;
import java.util.Deque;

//Реализовать class StackCalc, который содержит стек чисел с плавающей точкой (double).
// Выбрать наиболее удобную для этого коллекцию. Реализовать методы работы со стеком:
public class StackCalc {
    public Deque <Double> stack = new ArrayDeque();

    //3.1 public void push(double value) - положить value на вершину стека
    public void push(double value){
        stack.push(value);
    }

    //3.2 public double pop() - взять (убрать) значение с вершины стека
    public double pop(){
        return stack.pop();
    }

    //3.3 public void add() - сложить 2 верхних значения на стеке,
    // результат положить на стек. В итогу в стеке должно быть на один элемент меньше
    public void add(){
        stack.push(stack.pop()+stack.pop());
    }

    //3.4 public void sub() - вычесть верхнее значение на стеке, из следующего по глубине,
    // результат положить на стек. В итоге в стеке должно быть на один элемент меньше
    public void sub(){
        double value = stack.pop();
        stack.push( stack.pop()-value);
    }

    //3.5 public void mul() - умножить 2 верхних значения на стеке,
    // результат положить на стек. В итогу в стеке должно быть на один элемент меньше
    public void mul(){
        stack.push(stack.pop()*stack.pop());
    }

    //public void div() - поделить на верхнее значение на стеке, следующее по глубине,
    // результат положить на стек. В итоге в стеке должно быть на один элемент меньше
    public void div(){
        double value = stack.pop();
        stack.push(stack.pop()/value);
    }
}

class Calculate{ // Class Calculate, который содержит методы:
    //3.7 public static double calculation1(), возвращающую результат вычисления следующей формулы:
    //2.2*(3+12.1), используя класс StackCalc
    public static double calculation1(){
        StackCalc stackCalc = new StackCalc();
        stackCalc.push(2.2);
        stackCalc.push(3);
        stackCalc.push(12.1);
        stackCalc.add();
        stackCalc.mul();
        return stackCalc.pop();
    }

    //3.8 public static double calculation2(), возвращающую результат вычисления следующей формулы:
    //(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc
    public static double calculation2(){
        StackCalc stackCalc1 = new StackCalc();
        stackCalc1.push(87);
        stackCalc1.push(2);
        stackCalc1.push(13.001);
        stackCalc1.push(9.2);
        stackCalc1.sub(); //(13.001-9.2)
        stackCalc1.mul(); //2*(13.001-9.2)
        stackCalc1.add(); //(87+2*(13.001-9.2)
        StackCalc stackCalc2 = new StackCalc();
        stackCalc2.push(19);
        stackCalc2.push(3.33);
        stackCalc2.sub(); //(19-3.33)
        StackCalc stackCalc3 = new StackCalc();
        stackCalc3.push(55.6);
        stackCalc3.push(12.1);
        stackCalc3.sub(); //(55.6-12.1)
        StackCalc stackCalc4 = new StackCalc();
        stackCalc4.push(737.22);
        stackCalc4.push(24);
        stackCalc4.add(); //(737.22+24)
        StackCalc stackCalc5 = new StackCalc();
        stackCalc5.push(stackCalc1.pop());
        stackCalc5.push(stackCalc2.pop());
        stackCalc5.mul(); //(19-3.33)*(87+2*(13.001-9.2))
        StackCalc stackCalc6 = new StackCalc();
        stackCalc6.push(stackCalc4.pop());
        stackCalc6.push(stackCalc3.pop());
        stackCalc6.div(); //(737.22+24)/(55.6-12.1)
        StackCalc stackCalc7 = new StackCalc();
        stackCalc7.push(stackCalc5.pop());
        stackCalc7.push(stackCalc6.pop());
        stackCalc7.add(); //(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2))
        return stackCalc7.pop(); //результат
    }

    public static void main(String[] args) {
        System.out.println(Double.toString(calculation1()));
        System.out.println(Double.toString(calculation2()));
    }
}
