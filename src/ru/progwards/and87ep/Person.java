package ru.progwards.and87ep;

public class Person {
    private String name;
    private int age;
    private String country;
    public Person(){
        country="RU";
    }
    public Person(String name, int age){ //конструктор с параметрами String name,
        // int age, вызывающий конструктор по умолчанию, и
        // устанавливающий значения переменным name и age из соответствующих параметров;
        this.name=name;
        this.age=age;
    }
//    публичные функции String getName(), int getAge(), String getCountry(), возвращающие значения соответствующих переменных
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getCountry(){
        return new Person().country;
    }

    public static void main(String[] args) {
        System.out.println(new Person("name1",23).age);
    }
}
