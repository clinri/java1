package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//Создать статический метод
// public static void codeFile(String inFileName, String outFileName, char[] code, String logName),
// в котором прочитать файл inFileName и перекодировать его посимвольно в соответствии с заданным шифром,
// результат записать в outFileName. Шифр задается маcсивом char[] code,
// где каждому символу symbol оригинального файла соответствует символ code[(int)symbol] выходного файла.
// В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()
public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader reader = new FileReader(inFileName);
            FileWriter writer = new FileWriter(outFileName);
            try {
                Scanner scanner = new Scanner(reader);
                String out = "";
                while (scanner.hasNextLine()) {
                    char[] textArrIn = scanner.nextLine().toCharArray(); // помещаем каждую строку текста посимвольно в массив
//                    System.out.println(Arrays.toString(textArrIn));
                    for (int i = 0; i < textArrIn.length; i++) {
//                        System.out.println((int)textArrIn[i]);
                        out += code[(int)textArrIn[i]];
                    }
//                    System.out.println(out);
                    writer.write(out + "\n");
                    out = "";
                }
            } finally {
                reader.close();
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e);
            String errorLog = e.getMessage();
            try {
                FileWriter logWriter = new FileWriter(logName, true);
                try {
                    logWriter.write(errorLog + "\n");
                } finally {
                    logWriter.close();
                }
            } catch (IOException e1) {
                System.out.println(e1);
            }
        }
    }

    public static void main(String[] args) {
        char[] code = new char[60000];
        for (int i = 0; i < code.length; i++) {
            code[i] = (char) (i + 1);
        }
            codeFile("file1.txt", "file2.txt", code, "log.txt");
    }

}