package ru.progwards.java1.lessons.classes.figures;

public class FiguresCompare extends NestedFigures {
    static class CompareGr{
        boolean greater(Figure figure1, Figure figure2){
            return figure1.perimeter()>figure2.perimeter();
        }
    }

    // свойства
    private Figure[] figures;
    public CompareGr figuresComparator = new CompareGr();

    //конструкторы
    FiguresCompare(Figure[] figures){
        this.figures = figures;
    }

    FiguresCompare(Figure [] figures, CompareGr fc){
        this(figures);
        figuresComparator = fc;
    }

    Figure getMaxFigure(){
        Figure result = null;
        for (Figure figure:figures){
            if (result == null || figuresComparator.greater(figure,result))
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

        FiguresCompare fc = new FiguresCompare(figures);
        System.out.println("Фигура с максимальным периметром:");
        printInfo(fc.getMaxFigure());

        //локальный класс - потомок CompareGr
        class FiguresComparatorArea extends CompareGr{
            @Override
            boolean greater(Figure figure1,Figure figure2){
                return figure1.area()>figure2.area();
            }
        }

        FiguresComparatorArea fca = new FiguresComparatorArea();
        FiguresCompare fcArea=new FiguresCompare(figures,fca);
        System.out.println("(локальный класс) Фигура с максимальной площадью:");
        printInfo(fcArea.getMaxFigure());


        //анонимный класс - потомок CompareGr
        FiguresCompare fcArea1=
                new FiguresCompare(
                        figures,
                        new CompareGr(){
                            @Override
                            boolean greater(Figure figure1, Figure figure2){
                                return figure1.area()>figure2.area();
                            }
                        }
                );
        System.out.println("(анонимный класс) Фигура с максимальной площадью:");
        printInfo(fcArea1.getMaxFigure());
    }



}
