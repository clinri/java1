package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//Создать статический метод public static void filterFile(String inFileName, String outFileName, String filter),
// в котором прочитать файл inFileName и удалить символы, содержащиеся в String filter,
// результат записать в выходной файл. В случае возникновения ошибки, пробросить стандартное исключение выше,
// корректно закрыв все ресурсы
//
//Например файл содержит:
//Java — строго типизированный объектно-ориентированный язык программирования,
// разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
//obscene = " -,.()"
//Должен выдать результат:
//JavaстроготипизированныйобъектноориентированныйязыкпрограммированияразработанныйкомпаниейSunMicrosystemsвпоследующемприобретённойкомпаниейOracle
public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws Exception {
        try {
            FileReader reader = new FileReader(inFileName);
            FileReader readerFilter = new FileReader(filter);
            FileWriter writer = new FileWriter(outFileName);
            try {
                Scanner scannerFilter = new Scanner(readerFilter);
                char[] textFilter = scannerFilter.nextLine().toCharArray();
                //System.out.println(Arrays.toString(textFilter));
                char[] textIn;
                String text = "";
                boolean check = false;
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    textIn = scanner.nextLine().toCharArray();
                    //System.out.println(Arrays.toString(textIn));
                    for (int i = 0; i < textIn.length; i++) {
                        for (int k = 0; k < textFilter.length; k++) {
                            if (textIn[i] == textFilter[k]) {
                                check = true;
                            }
                        }
                        if (!check)
                            text += textIn[i];
                        check = false;
                    }
                    writer.write(text + "\n");
                    text="";
                }
            } finally {
                reader.close();
                readerFilter.close();
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            filterFile("file1.txt", "file2.txt", "key.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
