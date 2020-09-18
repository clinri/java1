package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Создать статический метод public static int calcEmpty(String fileName),
// в котором посчитать количество пустых строк в файле. В случае возникновения ошибок, вернуть -1
public class LineCount {
    public static int calcEmpty(String fileName) throws IOException{
        try {
            FileReader reader = new FileReader(fileName);
            try {
                Scanner scanner = new Scanner(reader);
                int i = 0;
                String str;
                while (scanner.hasNextLine()) {
                    if (scanner.nextLine().equals(""))
                        i++;
                }
                return i;
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new IOException("-1");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(calcEmpty("file1.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
