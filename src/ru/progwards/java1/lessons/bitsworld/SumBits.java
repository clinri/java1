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
        int intVal = value & 255; // перход к типу с большим числом цифр не достигая знакового бита
        // 255 (10) => 0b00000000_00000000_00000000_11111111 (2) - оставляем 8 нужных значщих битов;
        //System.out.println(Integer.toBinaryString(intVal));
        while (intVal != 0) {
            //System.out.println(Integer.toBinaryString(intVal));
            sum += intVal & 1; // плюсуем значение последнего бита
            //System.out.println(sum);
            intVal >>>= 1; // свиг вправо на 1 бит с заполнением нулями
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 243));
    }
}
