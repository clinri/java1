package ru.progwards.java1.SeaBattle.clinri;

import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.FireResult;

import java.util.Arrays;

public class SeaBattleAlg {
    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|

    char [][] field;

    void init(SeaBattle seaBattle){
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
        for (int i=0; i<seaBattle.getSizeY(); i++) {
            Arrays.fill(field[i], '~');
            System.out.print(i + "|");
            for (int j=0;j<seaBattle.getSizeX();j++){
                System.out.print(field[i][j]+"|");
            }
            System.out.println();
        }
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        int hits = 0;
        int sizeBigShipHor =0;
        int destroyedSizeShipHor=0;
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                if (field[y][x] == '.')
                    continue;
                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                if (sizeBigShipHor!=0 & fireResult == FireResult.HIT) {
                    sizeBigShipHor++;
                    continue;
                }
                if (sizeBigShipHor!=0 & fireResult == FireResult.DESTROYED){
                    destroyedSizeShipHor=sizeBigShipHor+1;
                    sizeBigShipHor=0;
                    if (x!=9)
                        field[y][x+1]='.';
                    if (y!=9){
                        if (x==9) {
                            for (int k = x+1-destroyedSizeShipHor; k <= x; k++) {
                                field[y + 1][k] = '.';
                            }
                        } else {
                            for (int k=x+1-destroyedSizeShipHor; k <= x+1; k++) {
                                field[y + 1][k] = '.';
                            }
                        }
                    }
                }
                if (fireResult != FireResult.MISS) {
                    hits++;
                    field[y][x]='X';
                    if (fireResult == FireResult.DESTROYED) //одна палуба
                        if (y !=9 ){
                            field[y+1][x]='.';
                            if (x > 0 & x < 9){
                                field[y][x-1]='.';
                                field[y][x+1]='.';
                                field[y+1][x-1]='.';
                                field[y+1][x+1]='.';
                            }
                            if (x==9)
                                field[y+1][x-1]='.';
                            if (x==0)
                                field[y+1][x+1]='.';
                        }
                    if (fireResult == FireResult.HIT) //больше одной палубы
                        sizeBigShipHor++;

                } else {
                    field[y][x]='.';
                    sizeBigShipHor=0;
                }
                if (hits >= 20)
                    break;
            }
        }
        System.out.println();
        System.out.println(" |0|1|2|3|4|5|6|7|8|9|");
        for (int i=0; i<seaBattle.getSizeY(); i++) {
            System.out.print(i + "|");
            for (int j=0;j<seaBattle.getSizeX();j++){
                System.out.print(field[i][j]+"|");
            }
            System.out.println();
        }
    }

    // функция для отладки
    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());

    }
}