package ru.progwards.java1.lessons.interfaces;
//Поместите исходные тексты с выполненным заданием в package ru.progwards.java1.lessons.interfaces
//
//Примечание: для отладки удобно использовать функцию public static void main(String[] args), она может
// присутствовать во всех выполненных задачах.
//
//Задача 1. Классы Animal, Cow, Hamster, Duck
//1.1 Для класса Animal из задач 1 и 2, домашнего задания к уроку 5 реализовать метод:
//public boolean equals(Object anObject), который возвращает true, если объекты равны и false если не равны
// по параметру - вес животного. Убедится, что при равном весе, утка все равно не равна хомяку. Обратите внимание
// на тип принимаемого параметра и подумайте над тем, что будет делать ваша программа, если в качестве параметра
// будет передан объект не являющийся экземпляром Animal.
//
//Для класса Animal реализовать интерфейс FoodCompare, который сравнивает животных по цене потребляемой еды.
//public interface FoodCompare {
//    public int compareFoodPrice();
//}
//
//Для этого
//1.2 В класс Animal добавить метод
//public double getFood1kgPrice(), который возвращает информацию о цене 1 кг еды.
//метод реализовать в виде switch по FoodKind со следующими значениями
//HAY : 20
//CORN: 50
//UNKNOWN: 0
//
//1.3 В класс Animal добавить метод
//public double getFoodPrice(), который возвращает информацию о цене еды для данного животного
// по формуле calculateFoodWeight() * getFood1kgPrice()
//
//1.4 В отдельном файле объявить interface FoodCompare
//interface FoodCompare {
//    public int compareFoodPrice(Animal animal);
//}
//
//1.5 В класс Animal реализовать
//public int compareFoodPrice(Animal aminal), который возвращает результаты сравнения цены еды для данного животного
// с ценой еды для другого животного, используя Double.compare;


// целых чисел на сортировку через интерфейс CompareWeight public static void sort(CompareWeight[] a)
public interface FoodCompare {
    public int compareFoodPrice(Animal animal);
}
