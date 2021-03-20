package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class UsageFrequency {
    static String strText = "";

    //Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов. Методы:
    //2.1 public void processFile(String fileName) - загрузить содержимое файла
    public static void processFile(String fileName) {
//        File fileInfo = new File(fileName);
//        System.out.println("путь к файлу: " + fileInfo.getPath());
//        System.out.println("файл существует?: " + fileInfo.exists());
//        System.out.println("последне изменение: " + new Date(fileInfo.lastModified()));

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                strText += scanner.next() + " ";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //2.2 public Map<Character, Integer> getLetters() - вернуть Map, который содержит все найденные буквы и цифры,
    // и количество раз, которое встретился каждый искомый символ.
    // Знаки препинания, такие как “.,!? @” и др не учитывать.

    public static void main(String[] args) {
        try {
            processFile("wiki.test.tokens");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(strText);

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
