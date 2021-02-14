package ru.progwards.java1.lessons.bigints;

public abstract class AbsInteger {

    abstract int num();

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int numAbs = num1.num() + num2.num();
        if (numAbs < 128 & numAbs > -129) return new ByteInteger((byte) numAbs);
        if (numAbs < 32768 & numAbs > -32769) return new ShortInteger((short) numAbs);
        return new IntInteger(numAbs);
    }

    public static void main(String[] args) {
        int num = 127;
        System.out.println(new ByteInteger((byte) num).toString());
        System.out.println(new ShortInteger((short) num).toString());
        System.out.println(new IntInteger(num).toString());
        System.out.println(add(new ByteInteger((byte) 100), new ShortInteger((short) 32760)));
    }
}

class ByteInteger extends AbsInteger {
    byte num;

    ByteInteger(byte num) {
        System.out.println("запущен конструктор ByteInteger с числом =>" + num);
        this.num = num;
    }

    int num() {
        return (int) num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}

class ShortInteger extends AbsInteger {
    short num;

    ShortInteger(short num) {
        System.out.println("запущен конструктор ShortInteger с числом =>" + num);
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    int num() {
        return (int) num;
    }
}

class IntInteger extends AbsInteger {
    int num;

    IntInteger(int num) {
        System.out.println("запущен конструктор IntInteger с числом =>" + num);
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    int num() {
        return num;
    }
}


