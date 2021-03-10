package ru.progwards.clinri.T103;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Реализовать метод с сигнатурой private int lineCount(String filename) который возвращает количество строк
// в файле filename. В случае ошибки пробросить исключение IOException со строкой сообщения "файл не найден"
public class test103 {
    private static int lineCount(String filename) throws IOException {
        try {
            FileReader reader = new FileReader(filename);
            try {
                Scanner scanner = new Scanner(reader);
                int i = 0;
                while (scanner.hasNextLine()) {
                    String strFromFile = scanner.nextLine();
                    //System.out.println(strFromFile);
                    i++;
                }
                return i;
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new IOException("файл не найден");
        }
    }

    public static void main(String[] args) {
        try{
            System.out.println(lineCount("file1.txt"));
        } catch (IOException e){
            System.out.println(e);
        }
    }

}
