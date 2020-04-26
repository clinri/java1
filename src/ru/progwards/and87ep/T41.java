package ru.progwards.and87ep;

public class T41 {
    public static void main(String[] args) {
        System.out.println(addAsStrings(20,1));
    }
    static int addAsStrings(int n1, int n2){
        return Integer.valueOf(Integer.toString(n1)+Integer.toString(n2));
    }
}