package ru.progwards.and87ep;

public class T62 {
    //    Описан класс
    static class Rectangle {
        private double a;
        private double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double area() {
            return a * b;
        }

        //    реализуйте метод compareTo с сигнатурой
        public int compareTo(Rectangle anRectangle) { //который должен сравнивать прямоугольники по величине их площади.
//    При сравнении a.compareTo(b) метод должен возвращать
//    a   > b : 1
//    a == b : 0
//    a   < b : -1//
//    Например//
//    прямоугольник 2x2  >  прямоугольника 1x1 - результат 1
//    прямоугольник 2x3 == прямоугольнику 3x2 - результат 0
//    прямоугольник 2x2  <  прямоугольника 3x3 - результат -1
            if (this.area() == anRectangle.area()){
                return 0;
            } else if (this.area() < anRectangle.area()){
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Rectangle rectan1 = new Rectangle(2,2);
        Rectangle rectan2 = new Rectangle(1,2);

        System.out.println(new Rectangle(2,3).compareTo(new Rectangle(3, 2)));
    }
}



