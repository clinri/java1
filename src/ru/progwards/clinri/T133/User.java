package ru.progwards.clinri.T133;

import java.util.Comparator;
import java.util.TreeSet;

class User {
    public Integer id;
    public String name;
    User (Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class main{
    public static void main(String[] args) {
        TreeSet<User> treeSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.id,o2.id);
            }
        });
        treeSet.add(new User(1,"Andrei"));
        treeSet.add(new User(3,"Sergei"));
        treeSet.add(new User(6,"Boris"));
        treeSet.add(new User(4,"Anastasia"));
        System.out.println(treeSet);
        TreeSet<User> treeSet1 = createSet();
        treeSet1.add(new User(1,"Andrei"));
        treeSet1.add(new User(3,"Sergei"));
        treeSet1.add(new User(6,"Boris"));
        treeSet1.add(new User(4,"Anastasia"));
        System.out.println(treeSet1);

    }
    // Создайте метод с сигнатурой public TreeSet<User> createSet() который создает и
    // возвращает TreeSet так, что бы пользователи оказались упорядочены по убыванию id
    //
    //
    //Подсказка 1
    //Нужно создать TreeSet, передав в конструктор Comparator, переопределив метод compare для класса User
    //
    //
    //Подсказка 2
    //Используйте Integer.compare, для сравнения id, только с небольшим дополнением
    public static TreeSet<User> createSet(){
        TreeSet<User> user = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.id,o1.id);
            }
        });
        return user;
    }
}