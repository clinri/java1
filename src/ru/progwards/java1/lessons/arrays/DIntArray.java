package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

//Реализовать динамический, саморастущий массив целых чисел, по следующей спецификации:
//
//3.1 в классе разместить private переменную - массив целых чисел.
//3.2 конструктор - по умолчанию.
//3.2 метод
//public void add(int num) - добавляет элемент num в конец массива, при этом размер массива должен увеличиться на 1.
// Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, и добавить в хвост элемент num.
//3.3 метод
//public void atInsert(int pos, int num) - добавляет элемент num в позицию pos массива, при этом размер массива должен
// увеличиться на 1. Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, c учетом
// того, что новый элемент окажется где-то в середине, и потом положить в нужный индекс элемент num.
//3.4 метод
//public void atDelete(int pos) - удаляет элемент в позиции pos массива, при этом размер массива должен уменьшиться на 1.
// Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, уже без элемента, который был в позиции pos.
//3.5 метод
//public int at(int pos) - возвращает элемент по индексу pos.
public class DIntArray {
    private int[] Array1 = {};

    public DIntArray() {
    }

    public void add(int num) {
        int[] Array1Copy = Arrays.copyOf(Array1, Array1.length + 1);
        Array1Copy[Array1Copy.length - 1] = num;
        this.Array1 = Array1Copy;
    }

    public void atInsert(int pos, int num) {
        int[] Array1Copy = new int[Array1.length + 1];
        System.arraycopy(Array1,0,Array1Copy,0,pos);
        System.arraycopy(Array1,pos,Array1Copy,pos+1,Array1.length-pos);
        Array1Copy[pos] = num;
        this.Array1 = Array1Copy;
    }
    public void atDelete(int pos){
        int[] Array1Copy = new int[Array1.length -1];
        System.arraycopy(Array1,0,Array1Copy,0,pos);
        System.arraycopy(Array1,pos+1,Array1Copy,pos,Array1.length-pos-1);
        this.Array1 = Array1Copy;
    }
    public int at(int pos){
        return Array1[pos];
    }

            public static void main (String[]args){
                DIntArray func = new DIntArray();
                System.out.println(Arrays.toString(func.Array1));
                func.add(5);
                System.out.println(Arrays.toString(func.Array1));
                func.add(3);
                System.out.println(Arrays.toString(func.Array1));
                func.atInsert(0, 8);
                System.out.println(Arrays.toString(func.Array1));
                func.atDelete(2);
                System.out.println(Arrays.toString(func.Array1));
                System.out.println(func.at(1));
            }

        }
