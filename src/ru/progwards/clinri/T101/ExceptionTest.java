package ru.progwards.clinri.T101;

public class ExceptionTest {
    public static Integer sqr(Integer n) {
        try {
            return n*n;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public static void testQ(){
        String str;
        str = "null";
        try {
            System.out.println(str.toString());
        }
        catch (Exception e) {
            System.out.println("null pointer");
        }
    }

    public static void main(String[] args) {
        System.out.println(sqr(null));
        testQ();
    }
}
