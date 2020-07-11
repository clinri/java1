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
        int nRazr = 1;
        while (valueTest.remainder(BigInteger.TEN).compareTo(BigInteger.ZERO) > 0) { // определение количества разрядов
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

    public static void main(String[] args) {
        ArrayInteger arrI = new ArrayInteger(5);
        arrI.fromInt(new BigInteger("451"));
        System.out.println(Arrays.toString(arrI.digits));
    }
}

