package ru.progwards.java1.SeaBattle.clinri;

import ru.progwards.java1.SeaBattle.SeaBattle;

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

    private static final int MINUS = 0b01;
    private static final int PLUS = 0b10;

    char field[][];
    SeaBattle seaBattle;
    int hits;

    void print() {
        for (int i = 0; i < seaBattle.getSizeY(); i++) {
            String str = "|";
            for (int j = 0; j < seaBattle.getSizeX(); j++) {
                str += field[j][i] + "|";
            }
            System.out.println(str);
        }
        System.out.println("-----------------------------");
    }

    void init(SeaBattle seaBattle) {
        hits = 0;
        this.seaBattle = seaBattle;
        field = new char[seaBattle.getSizeX()][seaBattle.getSizeY()];
        for (int i = 0; i < seaBattle.getSizeY(); i++) {
            Arrays.fill(field[i], ' ');
        }
        print();
    }

    // функция интелектуальной стрельбы
    void fireAndKill(int x, int y) {
        SeaBattle.FireResult result = fire(x, y);
        if (result == SeaBattle.FireResult.HIT)
            killShip(x, y);
    }

    private void killShip(int x, int y) {
        // корабль может быть горизонтальный или вертикальный
        boolean destroyed = killVertikal(x, y);
        if (!destroyed)
            killHorizontal(x, y);
    }

    int direction;

    private boolean killVertikal(int x, int y) {
        boolean destroyed = false;
        direction = MINUS | PLUS; // 01 или 10 = 11 => оба направления не стрелялись
        int i = 1;
        do {
            if ((direction & MINUS) != 0)
                destroyed = checkHit(fire(x, y - i), MINUS); //стреляем на уменьшение координаты y
            if ((direction & PLUS) != 0)
                destroyed = checkHit(fire(x, y + i), PLUS); //стреляем на увеличение координаты н
            i++;
        } while (direction != 0);
        return destroyed;
    }

    private boolean killHorizontal(int x, int y) {
        boolean destroyed = false;
        direction = MINUS | PLUS; // 01 или 10 = 11 => оба направления не стрелялись
        int i = 1;
        do {
            if ((direction&MINUS) != 0)
                destroyed = checkHit(fire(x - i, y), MINUS); //стреляем на уменьшение координаты х
            if ((direction&PLUS) != 0)
                destroyed = checkHit(fire(x + i, y), PLUS); //стреляем на увеличение координаты х
            i++;
        } while (direction != 0);
        return destroyed;
    }

    private boolean checkHit(SeaBattle.FireResult result, int fireDirection) {
        // проверяет убит ли корабль
        switch (result) {
            case MISS:
                direction &= ~fireDirection; //меняем направление стерьбы: если мимо 1 в битовой маске будет ноликом, а другие нолики не изменятся
                return false;
            case HIT:
                return false;
            case DESTROYED:
                direction = 0;
                return true;
        }
        return false;
    }

    SeaBattle.FireResult fire(int x, int y) {
        if (y >= 0 && y < seaBattle.getSizeX() && x >= 0 && x < seaBattle.getSizeY() &&
                field[x][y] == ' ' && hits < 20) {
            SeaBattle.FireResult result = seaBattle.fire(x, y);
            if (result == SeaBattle.FireResult.MISS)
                mark(x, y, '*');
            else {
                hits++;
                mark(x, y, 'X');
                if (result == SeaBattle.FireResult.DESTROYED)
                    markDestroyed();
            }
            print();
            return result;
        } else {
            return SeaBattle.FireResult.MISS;
        }
    }

    private void markDestroyed() {
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                if (field[x][y] == 'X')
                    markHit(x, y);
            }
        }
    }
    String test;
    private void markHit(int x, int y) {
        //if (x==7 && y==5)
            //test="здесь!";
        markDot(x - 1, y - 1);
        markDot(x, y - 1);
        markDot(x + 1, y - 1);
        markDot(x - 1, y + 1);
        markDot(x, y + 1);
        markDot(x + 1, y + 1);
        markDot(x - 1, y);
        markDot(x + 1, y);
    }

    private void markDot(int x, int y) {
        mark(x, y, '.');
    }

    // отмечаем на поле выстрел
    void mark(int x, int y, char mark) {
        if (y >= 0 && y < seaBattle.getSizeX() && x >= 0 && x < seaBattle.getSizeY() && field[x][y] == ' ') {
            field[x][y] = mark;
        }
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);
//        fireAndKill(7, 5);
//        fire(9, 3);
//         пример алгоритма:
//         стрельба по всем квадратам поля полным перебором
//        for (int y = 0; y < seaBattle.getSizeX(); y++) {
//            for (int x = 0; x < seaBattle.getSizeY(); x++) {
//                fireAndKill(x, y);
//            }
//        }
        stepFire(3);
        stepFire(1);
        stepFire(0);
        stepFire(2);
    }

    void stepFire(int offset) {
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = y + offset; x < seaBattle.getSizeY(); x += 4) {
                fireAndKill(x, y);
            }
            for (int x = y - 1; x >= -seaBattle.getSizeY(); x -= 4) {
                if (x>=0)
                    fireAndKill(x, y);
            }


        }
    }



    // функция для отладки
    public static void main(String[] args) {
        //System.out.println("Sea battle");
        double result = 0;
        //for (int i=0; i<1000; i++){
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        result += seaBattle.getResult();
        //}
        System.out.println(result);
    }
}