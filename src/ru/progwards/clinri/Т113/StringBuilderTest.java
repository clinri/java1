package ru.progwards.clinri.Т113;
//Реализуйте метод с сигнатурой public String invertWords(String sentence),
// который переставляет слова, в полученной фразе.
// В качестве исходного разделителя использовать пробел. В качестве соединительного точку.
//
//Например,
//invertWords("Буря мглою небо кроет") должен вернуть
//"кроет.небо.мглою.Буря"
public class StringBuilderTest {
    public static String invertWords(String sentence) {
        String[] wordSpase = sentence.split(" ");
        StringBuilder strBuild = new StringBuilder();
        for (String c : wordSpase) {
            strBuild.insert(0, c);
            strBuild.insert(0, ".");
        }
        return strBuild.toString().substring(1);
    }


    public static void main(String[] args) {
        System.out.println(invertWords("Буря мглою небо кроет"));
    }
}
