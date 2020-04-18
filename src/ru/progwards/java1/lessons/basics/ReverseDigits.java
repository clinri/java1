package ru.progwards.java1.lessons.basics;

public class ReverseDigits
{
    public static void main(String[] args)
    {
        System.out.println(reverseDigits(123));
    }
    public static int reverseDigits(int number)
    {
        int n_3=number/100; // третья цифра нового числа 1
        int n_2=number/10-10*n_3; // вторая цифра нового числа 2
        int n_1=number % (n_3*100+n_2*10); // первая цифра нового числа 3
        String str1=Integer.toString(n_1);
        String str2=Integer.toString(n_2);
        String str3=Integer.toString(n_3);
        return Integer.valueOf(str1+str2+str3);
    }
}
