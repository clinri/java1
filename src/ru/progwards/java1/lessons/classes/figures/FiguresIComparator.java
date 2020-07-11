package ru.progwards.java1.lessons.classes.figures;

import java.util.Comparator;

public class FiguresIComparator extends NestedFigures {
    // свойства
    private Figure[] figures1;
    public Comparator figuresComparator = new Comparator<Figure>(){
        @Override
        public int compare(Figure o1, Figure o2){
            return o1.compareTo(o2);
        }
    };

    //конструкторы
    FiguresIComparator(Figure[] figures){
        this.figures1 = figures;
    }

    FiguresIComparator(Figure [] figures1, Comparator<Figure> fc){
        this(figures1);
        figuresComparator = fc;
    }

    Figure getMaxFigure(){
        Figure result = null;
        for (Figure figure: figures1){
            if (result == null || figuresComparator.compare(figure,result)>0)
                result=figure;
        }
        return result;
    }

    public static void main(String[] args) {
        Segment segment=new Segment(5);
        Square square = new Square(5);
        Rectangle rectangle=new Rectangle(5,11);
        Circle circle=new Circle(5);
        Triangle triangle=new Triangle(3,4,5);

        Figure[] figures ={segment,square,rectangle,circle,triangle};

        for (Figure figure: figures){
            System.out.println(figure);
        }
        System.out.println();

        //анонимный класс - реализующий интерфейс
        FiguresIComparator fcArea1=
                new FiguresIComparator(
                        figures,
                        new Comparator<Figure>(){
                            @Override
                            public int compare(Figure o1, Figure o2){
                                return Double.compare(o1.area(),o2.area());
                            }
                        }
                );
        System.out.println("(анонимный класс - с реализайией интерфейса) Фигура с максимальной площадью:");
        printInfo(fcArea1.getMaxFigure());
    }



}