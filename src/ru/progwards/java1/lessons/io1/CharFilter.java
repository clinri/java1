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
            FileWriter writer = new FileWriter(outFileName);
            try {
                char[] textFilter = filter.toCharArray();
                String text = "";
                boolean check = false;
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    char[] textIn = scanner.nextLine().toCharArray();
                    //System.out.println(Arrays.toString(textIn));
                    for (int i = 0; i < textIn.length; i++) {
                        for (int k = 0; k < textFilter.length; k++) {
                            if (textIn[i] == textFilter[k])
                                check = true;
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
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String filter =",.";
        try {
            filterFile("file1.txt", "file2.txt", filter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
