package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UsageFrequency {
    static String strText = "";
    //Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов. Методы:
    //2.1 public void processFile(String fileName) - загрузить содержимое файла
    public static void processFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    strText += scanner.nextLine();
                }
            } catch (Exception e){
                System.out.println(e);
            }
    }

    public static void main(String[] args) {
        try {
            processFile("wiki.test.tokens");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(strText);

    }



}
