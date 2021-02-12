package ru.progwards.clinri;

public class T61 {
    //Напишите функцию, суммирующие значения элементов одномерного массива, содержащего целые числа. Сигнатура:
    public static int sumArrayItems(int[] a){
        int sum=0;
        for (int i=0; i<a.length; i++){
            sum += a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] a = {14, 25, 36, -48, 105, -76};
        int sum = sumArrayItems(a);
        System.out.println(sum);
//        Integer a1 = 6;
//        Integer b = 1;
//        System.out.println(a1.compareTo(b));
        System.out.println(intToGrade(5));


    }
    enum Grade{
        VERYBAD,
        BAD,
        SATISFACTORILY,
        GOOD,
        EXCELLENT,
        NOTDEFINED
    }

    static Grade intToGrade(int grade){
        switch (grade){
            case 1: return Grade.VERYBAD;
            case 2: return Grade.BAD;
            case 3: return Grade.SATISFACTORILY;
            case 4: return Grade.GOOD;
            case 5: return Grade.EXCELLENT;
            default: return Grade.NOTDEFINED;
        }
    }
}
