package ru.progwards.java1.lessons.bitsworld;

//1.1 Реализовать функцию public static int sumBits(byte value), которая суммирует все биты параметра value.
// Например, для двоичного числа 0100101 функция должна вернуть 3.
//
//Подсказки:
//используйте & с числом 1 для того, чтобы оставить только один правый значащий бит;
//используйте сдвиг вправо для того, чтобы проверить следующий бит.
public class SumBits {
    public static int sumBits(byte value) {
        int sum = 0;
        int intVal = value & 0b00000000_00000000_00000000_11111111;
        //System.out.println(Integer.toBinaryString(intVal));
        while (intVal != 0) {
            //System.out.println(Integer.toBinaryString(intVal));
            sum += intVal & 0b00000000_00000000_00000000_00000001;
            //System.out.println(sum);
            intVal >>>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 243));
    }
}
