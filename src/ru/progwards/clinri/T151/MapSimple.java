package ru.progwards.clinri.T151;

import java.util.HashMap;
import java.util.Map;

public class MapSimple {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Ivanov1", "Иванов Иван Иванович");
        hashMap.put("student1", "Студентов Ученик Изучаевич");
        hashMap.put("UmnikRD", "Умников Раз Думович");
        hashMap.put("tormoz_dk", "Тормозов Диск Колодкович");
        hashMap.put("Student2", "Студентов Ученик Изучаевич");
        String key = "Ivanov1";
        String fio = hashMap.get(key);
        System.out.printf("по ключу "+ key + " найдено значение: " + fio);
    }
}

class HashMapEntry {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Ivanov1", "Иванов Иван Иванович");
        hashMap.put("student1", "Студентов Ученик Изучаевич");
        hashMap.put("UmnikRD", "Умников Раз Думович");
        hashMap.put("tormoz_dk", "Тормозов Диск Колодкович");
        hashMap.put("Student2", "Студентов Ученик Изучаевич");

        for(Map.Entry<String, String> entry : hashMap.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        hashMap.remove("Student2");
        String remove = hashMap.remove("tormoz_dk");
        String remove2 = hashMap.remove("tormoz_dk2");
        System.out.println(remove);
        System.out.println(remove2);
        for(Map.Entry<String, String> entry : hashMap.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        System.out.println(hashMap);
    }

    //Реализуйте метод с сигнатурой HashMap<Integer, String> a2map(int[] akey, String[] aval), который создает
    // Map на основе пары массивов akey (ключи) и aval (значения). Первому элементу массива akey соответствует
    // первый элемент массива aval, и т.д. Размеры массивов одинаковые.
    static class homework151{
        HashMap<Integer, String> a2map(int[] akey, String[] aval){
            HashMap<Integer, String > result = new HashMap<>();
            for (int i=0;i<akey.length;i++){
                result.put(akey[i],aval[i]);
            }
            return result;
        }

        public static void main(String[] args) {

        }
    }
}
