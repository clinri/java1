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
        while (valueTest.divide(BigInteger.TEN).compareTo(BigInteger.ZERO) == 1) { // определение количества разрядов
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

    BigInteger toInt() {
        BigInteger result = new BigInteger("0");
        System.out.println(Arrays.toString(digits));
        for (int i = 0; i < digits.length; i++) {
            result = result.add(BigInteger.TEN.pow(i).multiply(new BigInteger(String.valueOf(digits[i]))));
            System.out.println(result);
        }
        System.out.println(result);
        return result;
    }

    boolean add(ArrayInteger num) {
        System.out.println(Arrays.toString(this.digits));
        System.out.println(Arrays.toString(num.digits));
        byte memo = 0;
        byte remind = 0;
        for (int i = 0; i < num.digits.length; i++) {
            if (i == this.digits.length - 1) {
                System.out.println("стоп");
            }
            remind = (byte) ((this.digits[i] + num.digits[i]) % 10 + memo);
            System.out.print(i + " " + remind);
            if (this.digits[i] + num.digits[i] >= 10) {
                memo = (byte) ((this.digits[i] + num.digits[i]) / 10);
            } else {
                memo = 0;
            }
            this.digits[i] = remind;
            System.out.println(" остаток " + memo);
            if (i == num.digits.length - 1 & num.digits.length < this.digits.length & memo != 0) {
                this.digits[i + 1] = (byte) (this.digits[i + 1] + memo);
                System.out.println("размер второго числа меньше первого и есть разряд для записи в следующий элемент массива");
            }

            if (i == this.digits.length - 1) {
                int lastNum = 0;
                for (int j = i + 1; j < num.digits.length; j++) {
                    lastNum += num.digits[j];
                }
                if (memo != 0 | lastNum != 0) {
                    Arrays.fill(digits, (byte) 0);
                    return false;
                } else {
                    return true;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        ArrayInteger arrI1 = new ArrayInteger(8);
        arrI1.fromInt(new BigInteger("12799845"));
        System.out.println(Arrays.toString(arrI1.digits));
        System.out.println(arrI1.toInt());

        ArrayInteger arrI2 = new ArrayInteger(6);
        arrI2.fromInt(new BigInteger("920998"));
        System.out.println(arrI1.add(arrI2));
        System.out.println(Arrays.toString(arrI1.digits));

    }
}

