package ru.progwards.java1.SeaBattle.clinri;
        import ru.progwards.java1.SeaBattle.SeaBattle;

        import java.util.Arrays;

public class SeaBattleAlgErr {
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

    void init(SeaBattle seaBattle) {
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        for (int i = 0; i < seaBattle.getSizeY(); i++) {
            Arrays.fill(field[i], ' ');
            //System.out.println(field[1][1]);
        }

    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        int hits = 0;
//        int x1 = 0; int Xmax = 0;
//        int Ymax = 0;
//        int sizeHittedBattle = 0;

        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            for (int x = 0; x < seaBattle.getSizeX(); x++) {
                if (field[x][y] == '.')
                    continue;
                SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
                if (fireResult != SeaBattle.FireResult.MISS)
                    hits++;
                if (hits >= 20)
                    return;
                if (fireResult == SeaBattle.FireResult.HIT) {
                    if (horizontal(seaBattle, x, y)) {
                        // горизональный корабль, добить и узнать длину!
                        killAndGetLengHor(seaBattle, x, y);
                    } else {
                        if (vertical(seaBattle, x, y)) {
                            // вертикальный корабль, добить и узнать длину!
                        } else {
                            // однопалубный корабль

                        }
                    }
                }
            }
        }

    }

    SeaBattle.FireResult fireResult;

    boolean horizontal(SeaBattle seaBattle, int x, int y) {
        switch (x) {
            case 0:
                if (field[x + 1][y] != '.') {
                    fireResult = seaBattle.fire(x + 1, y);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x + 1][y] = 'X';
                        return true;
                    } else field[x + 1][y] = '.';
                }
                break;
            case 9:
                if (field[x - 1][y] != '.') {
                    fireResult = seaBattle.fire(x - 1, y);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x - 1][y] = 'X';
                        return true;
                    } else field[x - 1][y] = '.';
                }
                break;
            default:
                if (field[x - 1][y] != '.') {
                    fireResult = seaBattle.fire(x - 1, y);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x - 1][y] = 'X';
                        return true;
                    } else field[x - 1][y] = '.';
                }
                if (field[x + 1][y] != '.') {
                    fireResult = seaBattle.fire(x + 1, y);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x + 1][y] = 'X';
                        return true;
                    } else field[x + 1][y] = '.';
                }
                break;
        }
        return false;
    }

    boolean vertical(SeaBattle seaBattle, int x, int y) {
        switch (y) {
            case 0:
                if (field[x][y + 1] != '.') {
                    fireResult = seaBattle.fire(x, y + 1);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x][y + 1] = 'X';
                        return true;
                    } else field[x][y + 1] = '.';
                }
                break;
            case 9:
                if (field[x][y - 1] != '.') {
                    fireResult = seaBattle.fire(x, y - 1);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x][y - 1] = 'X';
                        return true;
                    } else field[x][y - 1] = '.';
                }
                break;
            default:
                if (field[x][y - 1] != '.') {
                    fireResult = seaBattle.fire(x, y - 1);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x][y - 1] = 'X';
                        return true;
                    } else field[x][y - 1] = '.';
                }
                if (field[x][y] != '.') {
                    fireResult = seaBattle.fire(x, y + 1);
                    if (fireResult == SeaBattle.FireResult.HIT) {
                        field[x][y + 1] = 'X';
                        return true;
                    } else field[x][y + 1] = '.';
                }
                break;
        }
        return false;
    }

    int killAndGetLengHor(SeaBattle seaBattle, int x, int y) {
        for (int i = x; i > x - 4; i--) {
            if (field[i][y] == 'X') continue;
            if (field[i][y] == ' ') {
                fireResult = seaBattle.fire(i, y);
                if (fireResult == SeaBattle.FireResult.HIT) {
                }
                fireResult = seaBattle.fire(x, y - 1);
                if (fireResult == SeaBattle.FireResult.HIT) {

                }

            }
        }
        return 0;
    }


    void missAdd(boolean hor, boolean vert, int x, int y, int size) {
        field[x][y] = '.';
    }


    // функция для отладки
    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlgErr().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
        System.out.println(seaBattle);

    }
}




