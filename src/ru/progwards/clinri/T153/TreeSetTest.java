package ru.progwards.clinri.T153;

import java.util.TreeMap;

public class TreeSetTest {

    // Реализуйте метод с сигнатурой void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value), который добавляет пару key-value в map при выполнении следующих условий:
// значение с таким key должно отсутствовать
// значение key долно быть больше головы TreeMap
// значение key долно быть меньше хвоста TreeMap
        static void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value){
            if (!map.isEmpty()){
                if (!map.containsKey(key) & key < map.lastKey() & key > map.firstKey()) map.put(key, value);
            }

        }

    public static void main(String args[]) {
        TreeMap<Integer, String> map = new TreeMap();
//        System.out.println(map.containsKey(1) ? "ок" : "не ок");
        map.put(1, "Один");
        map.put(9, "Девять");

        checkAndAdd(map, 0, "Zero");
        checkAndAdd(map, 3, "Три");
        checkAndAdd(map, 2, "Два");
        checkAndAdd(map, 3, "Three");
        checkAndAdd(map, 10, "Ten");
        System.out.println(map);

    }
}
