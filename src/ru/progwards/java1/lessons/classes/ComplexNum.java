package ru.progwards.java1.lessons.classes;
//Реализовать класс ComplexNum, реализующий операции в комплексных числах. Напоминаем, что комплексное число записывается как z = a + bi, где z это комплексное число, a действительная часть, b мнимая часть, i обозначение мнимой части.
//a и b реализуем целыми числами
//
//3.1 конструктор
//public ComplexNum(int a, int b), который инициализирует комплексное число
//
//3.2 метод
//public String toString(), приведение к строке, выдать в формате a+bi, например, при a=1 и b=56 должно быть выдано 1+56i
//
//3.3 метод
//public ComplexNum add(ComplexNum num), сложение комплексных чисел по формуле:
//(a + bi) + (c + di) = (a + c) + (b + d)i
//
//3.4 метод
//public ComplexNum sub(ComplexNum num), вычитание комплексных чисел по формуле:
//(a + bi) - (c + di) = (a - c) + (b - d)i
//
//3.5 метод
//public ComplexNum mul(ComplexNum num), умножение комплексных чисел по формуле:
//(a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
//
//3.5 метод
//public ComplexNum div(ComplexNum num), деление комплексных чисел по формуле:
//(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
public class ComplexNum {
    int a;
    int b;
    public ComplexNum(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString(){
        return this.a + "+" + this.b + "i";
    }
    public ComplexNum add(ComplexNum num){
        //(a + bi) + (c + di) = (a + c) + (b + d)i
        int a = this.a;
        int b = this.b;
        int c = num.a;
        int d = num.b;
        return new ComplexNum(a+c, b+d);
    }
    public ComplexNum sub(ComplexNum num){
        //(a + bi) - (c + di) = (a - c) + (b - d)i
        int a = this.a;
        int b = this.b;
        int c = num.a;
        int d = num.b;
        return new ComplexNum(a-c, b-d);
    }
    public ComplexNum mul(ComplexNum num){
        //(a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
        int a = this.a;
        int b = this.b;
        int c = num.a;
        int d = num.b;
        return new ComplexNum(a*c-b*d, b*c+a*d);
    }
    public ComplexNum div(ComplexNum num){
        //(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
        int a = this.a;
        int b = this.b;
        int c = num.a;
        int d = num.b;
        return new ComplexNum((a*c + b*d)/(c*c+d*d), (b*c - a*d)/(c*c+d*d));
    }

    static class test1{
        public static void main(String[] args) {
            ComplexNum num1= new ComplexNum(5,6);
            ComplexNum num2= new ComplexNum(2,3);
            System.out.println(num1.add(num2).toString());
            System.out.println(num1.sub(num2).toString());
            System.out.println(num1.mul(num2).toString());
            System.out.println(num1.div(num2).toString());
        }
    }
}
