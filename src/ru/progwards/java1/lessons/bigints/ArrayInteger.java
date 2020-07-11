package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        BigInteger valueTest = value;
        int nRazr = 0;
        while (valueTest.divide(BigInteger.TEN).compareTo(BigInteger.ZERO) > 0) { // определение количества разрядов
            valueTest = valueTest.divide(BigInteger.TEN);
            nRazr++;
            System.out.println(nRazr + " " + valueTest);
        }
        for (int i = 0; i < nRazr; i++) {
            digits[i] = value.remainder(BigInteger.TEN).byteValue();
            value = value.subtract(new BigInteger(String.valueOf(digits[i])));
            value = value.divide(BigInteger.TEN);
            System.out.println(digits[i]);
        }
    }
    BigInteger toInt(){
        BigInteger result = new BigInteger("0");
        System.out.println(Arrays.toString(digits));
        for (int i=0; i<digits.length; i++){
            result=result.add(BigInteger.TEN.pow(i).multiply(new BigInteger(String.valueOf(digits[i]))));
            System.out.println(result);
        }
        System.out.println(result);
        return result;
    }

    boolean add(ArrayInteger num) {
        int number1 = this.toInt().intValue();
        int number2 = 0;
        int myltyply = 1;
        for (int i = 0; i < num.digits.length; i++) {
            number2 = number2 + myltyply * num.digits[i];
            myltyply *= 10;
        }
        System.out.println("второе число = " + number2);
        int sumInt = number1 + number2;

        int nRazr = 0;
        int sumIntTest = sumInt;
        while (sumIntTest / 10 > 0) { // определение количества разрядов
            sumIntTest = sumIntTest / 10;
            nRazr++;
            System.out.println(nRazr + " " + sumIntTest);
        }
        if (nRazr > digits.length) {
            Arrays.fill(digits, (byte) 0);
            return false;
        } else {
            for (int i = 0; i < nRazr; i++) {
                digits[i] = (byte) (sumInt % 10);
                sumInt -= digits[i];
                sumInt /= 10;
                System.out.println(digits[i]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ArrayInteger arrI1 = new ArrayInteger(14);
        arrI1.fromInt(new BigInteger("25937424601"));
        System.out.println(Arrays.toString(arrI1.digits));
        System.out.println(arrI1.toInt());

        ArrayInteger arrI2 = new ArrayInteger(3);
        arrI2.fromInt(new BigInteger("678"));
        arrI1.add(arrI2);
        System.out.println(Arrays.toString(arrI1.digits));

    }
}

