package ru.progwards.and87ep;

public class fract
{
    public static void main(String[] args)
    {
        System.out.println(fractional(1.53));
    }
    static double fractional(double num)
    {
        Double numObj=num;
        Integer intObj=numObj.intValue();
        return numObj-intObj;
    }
}


