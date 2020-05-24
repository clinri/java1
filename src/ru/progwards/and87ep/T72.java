package ru.progwards.and87ep;
//Написать программный код, который возвращает младший (нулевой) бит переменной byte value. Ответ нужно поместить в переменную int result.
//Таким образом, если младший бит параметра value равен 0, то result должен быть равен 0. Если младший бит равен 1, то и result должен быть равен 1.
public class T72 {
    public static void main(String[] args) {
        byte value = (byte)0b10101010;
        System.out.println(value);
        int i1=value;
        System.out.println(i1);
        System.out.println(Integer.toBinaryString(i1));
        int result=value & 0b00000000_00000000_00000001;
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));
    }
}
