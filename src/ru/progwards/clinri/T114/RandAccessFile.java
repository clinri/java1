package ru.progwards.clinri.T114;

import java.io.IOException;
import java.io.RandomAccessFile;

//Реализовать метод с сигнатурой public String setStars(String filename) который читает файл filename
// и меняет в нем каждый 10-йбайт на символ *, при этом конкатенируя оригинальный символ в строку ответа.
//В случае ошибки выбросить исключение IOException со строкой сообщения:равной имени класса оригинального сообщения
//
//Например,при содержимом файла:
//
//0123456789012345678A012345678B01
//
//новое содержимое должно быть
//
//012345678*012345678*012345678*01
//
//и метод должен вернуть "9AB"
public class RandAccessFile {
    public RandAccessFile(String inoutFileName, String rw) {
    }

    public static String setStars(String filename) throws IOException {
        String outEx = "";
        try (RandomAccessFile test = new RandomAccessFile(filename, "rw")) {
            for (int i = 9; i < test.length(); i += 10) {
                test.seek(i);
                int inputSym = test.read();
                System.out.println((char)inputSym);
                test.seek(i);
                test.writeBytes("*");
                outEx += (char)inputSym;
            }
        } catch (IOException e) {
            throw new IOException(e.getClass().getName());
        }
        return outEx;
    }

    public static void main(String[] args) {
        try {
            System.out.println(setStars("???"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
