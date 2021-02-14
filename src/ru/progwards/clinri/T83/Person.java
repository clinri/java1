package ru.progwards.clinri.T83;

public class Person {
    static class Child1{
        String hello(){
            return "привет";
        }
    }
    class Child2{
        String hello(){
            return "servus";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Person.Child1().hello());
        System.out.println(new Person().new Child2().hello());
    }
}
