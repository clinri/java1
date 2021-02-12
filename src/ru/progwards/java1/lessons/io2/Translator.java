package ru.progwards.java1.lessons.io2;

import java.sql.SQLOutput;

//Создать класс Translator - переводчик, который будет переводить предложения с одного языка на другой
//
//2.1 Конструктор Translator(String[] inLang, String[] outLang), где inLang и outLang - массивы слов на разных языках,
// например русском и английском. Сохранить значения параметров в приватных свойствах класса
//
//2.2  Метод public String translate(String sentence), в котором найти слова, содержащиеся
// в sentence и в inLang и заменить их на соответствующие в outLang.
// Пунктуация должна быть соблюдена (скопирована из оригинальной строки).
// При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте.
// В inLang и outLang все слова хранятся в нижнем регистре.
//
//Например, фраза
//"Hello World!" будет переведена как "Привет Мир!"
//при наличии слов "hello", "world" в inLang и "привет", "мир" в outLang
public class Translator {
    private String[] inLang;
    private String[] outLang;

    Translator(String[] inLang, String[] outLang) {
        try {
            this.inLang = inLang;
            this.outLang = outLang;
        } catch (Exception e) {
            System.out.println("ошибка в строке:" + e.getStackTrace()[0].getLineNumber() + " описание: " + e.getMessage());
        }
    }

    public String translate(String sentence) {
        String[] wordsIn = getWords(sentence);
        String[] wordsOut = new String[wordsIn.length];
        for (int i = 0; i < wordsIn.length; i++) {
            wordsOut[i] = translateWord(wordsIn[i]);
            wordsOut[i] = fixBigLetter(wordsIn[i], wordsOut[i]);
        }
        for (int i = 0; i < wordsIn.length; i++) {
            sentence = sentence.replaceAll(wordsIn[i], wordsOut[i]);
        }
        return sentence;
    }

    private String fixBigLetter(String wordsIn, String wordsOut) {
        StringBuilder fix = new StringBuilder(wordsOut);
        Character bigLetterIn = wordsIn.substring(0, 1).charAt(0);
        if (Character.isUpperCase(bigLetterIn)) { // заглавный ли первый символ?
            fix.setCharAt(0, Character.toUpperCase(wordsOut.substring(0, 1).charAt(0)));
            wordsOut = fix.toString();
        }
        return wordsOut;
    }

    private String translateWord(String s) {
        for (int j = 0; j < inLang.length; j++) {
            if (s.toLowerCase().compareTo(inLang[j]) == 0) {
                return outLang[j];
            }
        }
        return s;
    }

    private String[] getWords(String sentence) {
        String str = "";
        for (char c : sentence.trim().toCharArray())
            if (Character.isAlphabetic(c) | Character.isSpaceChar(c)) str += c;
        str.replace("  ", " ");
        return str.split(" ");
    }


    public static void main(String[] args) {
        String inLang = "hello,world";
        String outLang = "привет,мир";
        Translator translator = new Translator(inLang.split(","), outLang.split(","));
        System.out.println(translator.translate("Hello World! Hello..."));
    }
}
