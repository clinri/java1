package ru.progwards.and87ep;

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
    }
}
