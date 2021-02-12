package ru.progwards.clinri.Т131;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Array2Set {
    public static Set<Integer> a2set(int[] a){
        Set <Integer> setInt = new HashSet();
        for (int i=0; i<a.length;i++){
            setInt.add(a[i]);
        }
        return setInt;
    }

    public static void main(String[] args) {
        int a[] = new int[15];
        for (int i=0;i<a.length;i++){
            a[i]=i;
        }
        System.out.println(Arrays.toString(a));
        a[2]=a[3];
        a[5]=a[7];
        System.out.println(Arrays.toString(a));
        Iterator <Integer> iter = a2set(a).iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
    }
}
