package ru.progwards.java1.lessons.collections;

import java.util.Arrays;
import java.util.Iterator;
//Сделать итератор по одномерному массиву, реализовать методы hasNext() и next(). Шаблон пустого итератора:
public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int currentSize;
    private int currentIndex;

    ArrayIterator(T[] array) {
        this.array = array;
        this.currentSize = array.length;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext()  {
        if (this.currentIndex < this.currentSize && this.array[currentIndex] != null)
            return true;
        else
            return false;
    }

    @Override
    public T next() throws IndexOutOfBoundsException {
        T result = this.array[this.currentIndex++];
        return result;
    }

    public static void main(String[] args) {
        int volumeArr = 10;
        Integer [] arrInt = new Integer[volumeArr];
        for (int i=0;i<volumeArr;i++){
            arrInt[i]=i;
        }
        for (int val: arrInt){
            System.out.println(val);
        }
        ArrayIterator<Integer> arrIterator = new ArrayIterator(arrInt);
        while (arrIterator.hasNext()){
            System.out.println(arrIterator.next());
        }
    }
}
