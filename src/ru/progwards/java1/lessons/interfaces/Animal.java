package ru.progwards.java1.lessons.interfaces;
// ДЗ H5
//Реализовать класс Animal, содержащий:

public class Animal implements FoodCompare, CompareWeight {

    double weight; //свойство

    enum AnimalKind{
        ANIMAL, COW, HAMSTER, DUCK
    }
    enum FoodKind{
        UNKNOWN, HAY, CORN;
    }

    //1.0 Реализовать конструктор
    //public Animal(double weight), который сохраняет вес животного.
    public Animal(double weight){ //конструктор
        this.weight = weight;
    }

    //1.1 Метод:
    //public AnimalKind getKind(), который возвращает вид животного (enum AnimalKind - ANIMAL, COW, HAMSTER, DUCK).
    // В данном классе вернуть ANIMAL
    public AnimalKind getKind(){
        return AnimalKind.ANIMAL;
    }

    //1.2 Метод
    //public FoodKind getFoodKind(), который возвращает вид еды, (enum FoodKind - UNKNOWN, HAY, CORN).
    // В данном классе вернуть UNKNOWN
    public FoodKind getFoodKind(){
        return FoodKind.UNKNOWN;
    }

    //1.3 Метод
    //public String toString(), который возвращает информацию о животном в формате:
    //I am <AnimalKind>, eat <FoodKind>
    @Override
    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }

    //2.1 В классе Animal реализовать метод:
    //public double getWeight(), который возвращает вес животного
    public double getWeight() {
        return weight;
    }

    //2.2 Реализовать метод
    //public double getFoodCoeff(), который возвращает коэффициент веса еды к весу тела животного.
    // Для класса Animal это 0.02
    public double getFoodCoeff() {
        return 0.02;
    }

    //2.6 Для класса Animal, реализовать метод:
    //public double calculateFoodWeight(), который рассчитывает необходимый вес еды,
    //по формуле - вес-еды = вес-животного * коэффициент веса тела.
    public double calculateFoodWeight() {
        return weight * this.getFoodCoeff();
    }

    //2.7 Для класса Animal, создать метод
    //public String toStringFull(), что бы он возвращал информацию о животном в формате:
    //I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>
    public String toStringFull() {
        return "I am " + this.getKind() + ", eat " + this.getFoodKind() + " " + this.calculateFoodWeight();
    }

    // ДЗ H8
    //Для класса Animal из задач 1 и 2, домашнего задания к уроку 5 реализовать метод:
    //public boolean equals(Object anObject), который возвращает true, если объекты равны и false если не равны
    // по параметру - вес животного. Убедится, что при равном весе, утка все равно не равна хомяку. Обратите внимание
    // на тип принимаемого параметра и подумайте над тем, что будет делать ваша программа, если в качестве параметра
    // будет передан объект не являющийся экземпляром Animal.
    @Override
    public boolean equals(Object anObject){
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return animal.weight == this.weight;
    }
    //1.2 В класс Animal добавить метод
    //public double getFood1kgPrice(), который возвращает информацию о цене 1 кг еды.
    //метод реализовать в виде switch по FoodKind со следующими значениями
    //HAY : 20
    //CORN: 50
    //UNKNOWN: 0
    public double getFood1kgPrice(){
        switch (this.getFoodKind()){
            case HAY: return 20;
            case CORN: return 50;
            case UNKNOWN: return 0;
            default: return 0;
        }
    }

    //1.3 В класс Animal добавить метод
    //который возвращает информацию о цене еды для данного животного по формуле calculateFoodWeight() * getFood1kgPrice()
    public double getFoodPrice(){
        return this.calculateFoodWeight() * this.getFood1kgPrice();
    }
    //1.4 В отдельном файле объявить interface FoodCompare
    //interface FoodCompare {
    //public int compareFoodPrice(Animal animal);
    //1.5 В класс Animal реализовать
    //public int compareFoodPrice(Animal aminal), который возвращает результаты сравнения цены еды для данного животного
    // с ценой еды для другого животного, используя Double.compare;
    public int compareFoodPrice(Animal animal){
        return Double.compare(this.getFoodPrice(),animal.getFoodPrice());
    }

    //3.1 Создать интерфейс CompareWeight
    //3.2 В нем создать public enum CompareResult, со значениями LESS, EQUAL, GREATER
    //3.3 Интерфейс должен содержать метод public CompareResult compareWeight(CompareWeight smthHasWeigt)
    //
    //3.4 Для класса Animal реализовать интерфейс CompareWeight..Сравнение сделать на основе веса животного.
    //Метод CompareResult compareWeight должен возвращать
    //LESS если свой вес < веса параметра метода
    //EQUAL если свой вес = веса параметра метода
    //GREATER если свой вес > веса параметра метода

    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Animal newAnimal = (Animal) smthHasWeigt;
        switch (Double.compare(this.getWeight(), newAnimal.getWeight())) {
            case -1:
                return CompareResult.LESS;
            case 0:
                return CompareResult.EQUAL;
            case 1:
                return CompareResult.GREATER;
            default:
                return CompareResult.EQUAL;
        }
    }

    public static void main(String[] args){
        System.out.println(new Hamster(12).toString());
        Duck duck1 = new Duck(1700);
        Hamster hum1=new Hamster(1500);
        Cow cow1=new Cow(2400);
        Object obj1=new Object();
        System.out.println("равны ли животные? "+duck1.equals(hum1));
        System.out.println(hum1.getFood1kgPrice());

        System.out.println(duck1.compareWeight(hum1));
        System.out.println(duck1.getWeight());
        System.out.println(hum1.getWeight());

        System.out.println(duck1.getWeight());
        System.out.println(hum1.getWeight());
        System.out.println(duck1.calculateFoodWeight());
        System.out.println(hum1.calculateFoodWeight());
        System.out.println(hum1.compareWeight(duck1));
        Food fod1 = new Food(120);
        Food fod2 = new Food(130);
        System.out.println(fod1.getWeight());
        System.out.println(fod2.getWeight());
        System.out.println(fod1.compareWeight(fod2));
        CompareWeight[] arr = {cow1,duck1,hum1};
        CompareWeight.sort(arr);
        for (var value:arr){
            System.out.println("Элемент " + ((Animal)value).weight + " " + ((Animal)value).getKind());
        }

    }

}
