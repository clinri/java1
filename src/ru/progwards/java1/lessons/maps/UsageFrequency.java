package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.util.*;

public class UsageFrequency {
    ArrayList<String> strList = new ArrayList();

    //Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов. Методы:
    //2.1 public void processFile(String fileName) - загрузить содержимое файла
    public void processFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            String strText = "";
            while (scanner.hasNextLine()) {
                strText += scanner.nextLine() + " ";
                if (strText.length() > 1000000) { // String большего размера не работал корректно
                    strList.add(strText);
                    strText = "";
                }
            }
            strList.add(strText);
            strList.trimToSize();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void copyData(String[] src, String[] dst) {
        for (int i = 0; i < src.length; i++)
            dst[i] = src[i];
    }

    //2.2 public Map<Character, Integer> getLetters() - вернуть Map, который содержит все найденные буквы и цифры,
    // и количество раз, которое встретился каждый искомый символ.
    // Знаки препинания, такие как “.,!? @” и др не учитывать.
    public Map<Character, Integer> getLetters() {
        Map<Character, Integer> hashMap = new TreeMap();
        for (String strText : strList) {
            char[] chars = strText.toCharArray();
            int intValue = 0;
            for (int i = 0; i < chars.length; i++) {
                if (!(Character.isDigit(chars[i]) | Character.isLetter(chars[i]))) continue;
                if (hashMap.isEmpty()) {
                    hashMap.put(chars[i], 1);
                } else {
                    if (hashMap.containsKey(chars[i])) {
                        intValue = hashMap.get(chars[i]);
                        hashMap.replace(chars[i], intValue + 1);
                    } else
                        hashMap.put(chars[i], 1);
                }
            }
        }
        return hashMap;
    }

    //2.3 public Map<String, Integer> getWords() - вернуть Map, который содержит все найденные слова
    // и количество раз, которое каждое слово встретилось. Знаки препинания,
    // такие как “.,!? @” и др являются разделителями.
    public Map<String, Integer> getWords() {
        Map<String, Integer> hashMap = new TreeMap();
        String[] words;
        for (String strText : strList) {
            words = strText.split("[<>-@='\"()/!.,;:?\\- ]");
            int intValue = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == 0) continue;
                //if (!(Character.isLetter(words[i].charAt(0)) | Character.isDigit(words[i].charAt(0)))) continue;
                if (hashMap.isEmpty()) {
                    hashMap.put(words[i], 1);
                } else {
                    if (hashMap.containsKey(words[i])) {
                        intValue = hashMap.get(words[i]);
                        hashMap.replace(words[i], intValue + 1);
                    } else
                        hashMap.put(words[i], 1);
                }
            }
        }
        return hashMap;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        UsageFrequency usageFrequency = new UsageFrequency();
        usageFrequency.processFile("wiki.test.tokens");

        //System.out.println(strText);
//        System.out.println(strText.length());
        System.out.println(usageFrequency.getLetters().toString());
        System.out.println("букв " + usageFrequency.getLetters().size());
        TreeMap<String, Integer> treeMap = (TreeMap<String, Integer>) usageFrequency.getWords();
        System.out.println(treeMap.toString());
        System.out.println("слов " + treeMap.size());
        int i = 0;
//        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
////            System.out.println(entry);
//            i++;
//            //if (i>10) break;
//        }


//        String str = "Это строка, она большая";
//
//        File file = new File("E:\\bandr\\IdeaProjects\\Progwards\\wiki.test.tokens");
//
//        File fileInfo = new File("E:\\bandr\\IdeaProjects\\Progwards\\wiki.test.tokens");
//        System.out.println("путь к файлу: " + fileInfo.getPath());
//        System.out.println("файл существует?: " + fileInfo.exists());
//        System.out.println("последне изменение: " + new Date(fileInfo.lastModified()));
//
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNext()){
//                String word = scanner.next();
//                System.out.println("Слово: " + word);
//            }
//        } catch (FileNotFoundException e){
//            System.out.print(e);
//        }
    }
}
