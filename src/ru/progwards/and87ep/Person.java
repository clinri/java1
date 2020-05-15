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
        Person personObj1=new Person();
        return personObj1.country;
    }
}
