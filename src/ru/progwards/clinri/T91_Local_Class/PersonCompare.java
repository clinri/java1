package ru.progwards.clinri.T91_Local_Class;

class Person {
    public String name;
    public Person(String name) {
        this.name = name;
    }
}

public class PersonCompare {
    public int compare(Person p1, Person p2) {
        return 0;
    }

    public static void main(String[] args) {

        Person p1 = new Person("Andrei");
        Person p2 = new Person("Vova");
        PersonCompare personCompare =
                new PersonCompare() { //анонимный класс
                    @Override
                    public int compare(Person p1, Person p2) {
                        return p1.name.compareTo(p2.name);
                    }
                };
        System.out.println(personCompare.compare(p1,p2));
    }
}

