package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

/*
Сделать итератор MatrixIterator по двумерному массиву (матрице),
который разворачивает матрицу в линейную последовательность построчно:
a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]

Шаблон для итератора взять от ArrayIterator
 */
public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;
    private int currentIndex;
    private int currentIndexRow;
    private int currentIndexCol;
    private int currentSize;

    MatrixIterator(T[][] array) {
        System.out.println("Конструктор запущен");
        this.array = array;
        currentIndex = 0;
        currentIndexRow = 0;
        currentIndexCol = 0;
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            currentSize += array[i].length;
        }
        System.out.println("Размер одномерного массива: " + currentSize);
    }

    @Override
    public boolean hasNext() {
        return  currentIndex < currentSize;
    }

    @Override
    public T next() throws IndexOutOfBoundsException {
        T result = array[currentIndexRow][currentIndexCol];
        currentIndex++;
        currentIndexCol++;
        if (currentIndexCol == array[currentIndexRow].length) {
            currentIndexRow++;
            currentIndexCol = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[][] arrInt = new Integer[4][4];
        arrInt[0] = new Integer[]{1, 2, 3, 4};
        arrInt[1] = new Integer[]{5, 6, 7, 8};
        arrInt[2] = new Integer[]{9, 10, 11, 12};
        arrInt[3] = new Integer[]{13, 14, null, 16};

        for (Integer[] val1 : arrInt) {
            for (Integer val2 : val1) {
                System.out.println(val2);
            }
        }
        System.out.println("==");
        MatrixIterator <Iterator> arrIterator = new MatrixIterator(arrInt);
        while (arrIterator.hasNext()) {
            System.out.println(arrIterator.next());
        }
    }
}



