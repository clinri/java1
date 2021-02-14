package ru.progwards.java1.SeaBattle.clinri;

import ru.progwards.java1.SeaBattle.SeaBattle;

import java.util.Arrays;

public class SeaBattleAlgErr3 {
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

    char[][] field;
    int hits = 0;

    void init(SeaBattle seaBattle) {
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        for (int i = 0; i < seaBattle.getSizeY(); i++) {
            Arrays.fill(field[i], ' ');
            System.out.println(field[1][1]);
        }

    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);

        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
//        for (int y = 0; y < seaBattle.getSizeX(); y++) {
//            for (int x = 0; x < seaBattle.getSizeY(); x++) {
//                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
//            }
//        }
        // запуск алгоритма 4х4 запуск с левого нижнего угла
        // по диагонали 0, 3; 4, 3
        battleAlgorithm4Pal(seaBattle, 0, 3);

    }

    // алгоритм:
    // стрельба по диагонали в клетках 4х4
    public void battleAlgorithm4Pal(SeaBattle seaBattle, int x1, int y1) {
        for (int y = y1; y >= y1 - 4; y--) {
            if (y > seaBattle.getSizeX()) continue;
            for (int x = 0; x < x1 + 4; x++) {
                if (x > seaBattle.getSizeY()) continue;
                if (hits >= 20) return;
                if (field[x][y] == '.') continue;
                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                if (fireResult != SeaBattle.FireResult.MISS) {
                    field[x][y] = '.';
                    hits++;
                }
                if (fireResult == SeaBattle.FireResult.HIT) {
                    killNext(seaBattle, x, y);
                }
            }
        }
    }

    public void killNext(SeaBattle seaBattle, int x1, int y1) {
        int x = x1;
        //проверка вертикали
        for (int y = y1 - 1; y < y1 + 1; y = y + 2) {
            if (y > seaBattle.getSizeX()) continue;
            if (x > seaBattle.getSizeY()) continue;
            if (hits >= 20) return;
            if (field[x][y] == '.') continue;
            if (field[x][y] == ' ') {
                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                if (fireResult != SeaBattle.FireResult.MISS) {
                    field[x][y] = '.';
                    hits++;
                }
                if (fireResult == SeaBattle.FireResult.HIT) {
                    field[x][y] = 'Х';
                    field[x - 1][y] = '.';
                    field[x + 1][y] = '.';
                    hits++;
                    killNextVert(seaBattle, x, y);
                }
                if (fireResult == SeaBattle.FireResult.DESTROYED) {
                    field[x][y] = 'Х';
                    field[x - 1][y] = '.';
                    field[x + 1][y] = '.';
                    hits++;
                    return;
                }
            }
        }
    }

    public void killNextVert(SeaBattle seaBattle, int x1, int y1) {
        int x = x1;
        //проверка вертикали
        for (int y = y1 + 1; y < y1 + 2; y++) {
            if (y > seaBattle.getSizeX()) continue;
            if (x > seaBattle.getSizeY()) continue;
            if (hits >= 20) return;
            if (field[x][y] == '.') continue;
            if (field[x][y] == ' ') {
                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                if (fireResult != SeaBattle.FireResult.MISS) {
                    field[x][y] = '.';
                    hits++;
                }
                if (fireResult == SeaBattle.FireResult.HIT) {
                    field[x][y] = 'Х';
                    field[x - 1][y] = '.';
                    field[x + 1][y] = '.';
                    hits++;
                    killNextVert(seaBattle, x, y);
                }
                if (fireResult == SeaBattle.FireResult.DESTROYED) {
                    field[x][y] = 'Х';
                    field[x - 1][y] = '.';
                    field[x + 1][y] = '.';
                    hits++;
                    return;
                }
            }
        }
    }



            // функция для отладки
            public static void main (String[]args){
                System.out.println("Sea battle");
                SeaBattle seaBattle = new SeaBattle(true);
                new SeaBattleAlgErr3().battleAlgorithm(seaBattle);
                System.out.println(seaBattle.getResult());
                System.out.println(seaBattle);
            }
        }
