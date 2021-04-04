package ru.progwards.clinri.T151;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestHashMap {
    //Создайте метод с сигнатурой int fillHoles(Map<Integer, String> map, int size), который вставляет в HashMap
    // пару <n> "Число n", если она там отсутствует,  Проверить от 1 до максимального числа size включительно.
    // Метод возвращает количество добавленных элементов. Пример пары: 1 "Число 1"
    int fillHoles(Map<Integer, String> map, int size) {
        int n = 0;
        for (int i = 1; i <= size; i++) {

            if (!map.isEmpty()) {
                if (map.containsKey(i))
                    continue;
                else {
                    map.put(i, "Число " + i);
                    n++;
                }
            } else {
                map.put(i, "Число " + i);
                n++;
            }
        }
        return n;
    }

    HashMap<Integer, String> a2map(int[] akey, String[] aval){
        HashMap<Integer, String > result = new HashMap<>();
        for (int i=0;i<akey.length;i++){
            result.put(akey[i],aval[i]);
        }
        return result;
    }

    public static void main(String[] args) {
//        Map<Integer, String> map = new TreeMap<>();
//        map.put(5, "Число 5");
//        map.put(7, "Число 7");
//        System.out.println(new TestHashMap().fillHoles(map, 9));
        Map<Integer, String> map1 = new HashMap<>();
        System.out.print(new TestHashMap().fillHoles(map1, 4) + ":");
        System.out.println(map1);

        int akey1[] = {8, 3, 4};
        String aval1[] = {"Число 8", "Число 3", "Число 4"};
        Map<Integer, String> map2 = new TestHashMap().a2map(akey1, aval1);
        System.out.print(new TestHashMap().fillHoles(map2, 5)+":");
        System.out.println(map2);

        int akey2[] = {1, 3, 4};
        String aval2[] = {"Number 1", "Number 1", "Number 4"};
        Map<Integer, String> map3 = new TestHashMap().a2map(akey2, aval2);
        System.out.print(new TestHashMap().fillHoles(map3, 5)+":");
        System.out.println(map3);
    }

}
