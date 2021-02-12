package ru.progwards.clinri.T111;

import java.io.IOException;

public class TryWithResources {
    public static void doSomething(int n) throws IOException {
        System.out.println("doing something");
        throw new IOException("Исключяние в doSomething");
    }
    public static void test(int n) throws IOException{
        try {
            doSomething(n);
        } catch (IOException e){
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("finally executed");
        }
    }

    public static void main(String[] args) {
        try{
            test(2);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


    }
}
