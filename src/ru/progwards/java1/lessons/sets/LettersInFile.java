package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.util.*;

//Реализовать класс, считывающий содержимое файла и возвращающего набор букв, которые встречались в этом файле.
// Буквы, это латинские [A..Z[ и [a..z] и русские [А..Я] и [а..я], остальные символы надо игнорировать
//
//3.1 Метод public static String process(String fileName) - вернуть все буквы, которые встретились в файле,
// сконкатенированные в виде строки. Буквы должны быть упорядочены по алфавиту, типа “ADEF...”.
// Все возникающие исключения, по работе с потоками, пробросить выше.
public class LettersInFile {

    static Set<Character> allowedLetters = new LinkedHashSet<>();
    static Set<Character> result = new TreeSet<>();

    static void init() {
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'А');
        System.out.println((int) 'Я');
        System.out.println((int) 'а');
        System.out.println((int) 'я');

        for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
            allowedLetters.add((char)i);
        }
        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
            allowedLetters.add((char)i);
        }
        for (int i = (int) 'А'; i <= (int) 'Я'; i++) {
            allowedLetters.add((char)i);
        }
        for (int i = (int) 'а'; i <= (int) 'я'; i++) {
            allowedLetters.add((char)i);
        }
        for (Character charObj : allowedLetters)
            System.out.println(charObj);
    }

    public static String process(String fileName) throws Exception {
        init();
        FileReader fileReader = new FileReader(fileName);
        for (int intObj; (intObj =  fileReader.read())>=0;){
            if (allowedLetters.contains((char)intObj)) {
                result.add((char) intObj);
                System.out.println(result);
                System.out.println((char) intObj);
            }
        }
        String str = "";
        for (Character chObj : result)
            str += chObj.toString();
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) throws Exception {
        process("file.txt");
    }
}
