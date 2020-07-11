package ru.progwards.clinri.T92_BigDecimal;

import org.w3c.dom.css.Rect;

import java.math.BigDecimal;

public class AreaBigDecimal {
    static class Rectangle {

        Rectangle(BigDecimal a, BigDecimal b) {
            this.a = a;
            this.b = b;
        }
        public BigDecimal a;
        public BigDecimal b;
    }

    static boolean rectCompare(Rectangle r1, Rectangle r2){
        //multiply()
        if (r1.a.multiply(r1.b).compareTo(r2.a.multiply(r2.b)) == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        BigDecimal a1 = new BigDecimal("100");
        BigDecimal b1 = new BigDecimal("50");
        Rectangle r1= new Rectangle(a1,b1);

        BigDecimal a2 = new BigDecimal("50");
        BigDecimal b2 = new BigDecimal("101");
        Rectangle r2= new Rectangle(a2,b2);

        System.out.println(rectCompare(r1,r2));
        //System.out.println(rectCompare(new Rectangle(2,3),new Rectangle(3,2));
    }

}
