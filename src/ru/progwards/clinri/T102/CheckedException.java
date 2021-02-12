package ru.progwards.clinri.T102;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) {
        //FileWriter writer=new FileWriter("?????",false);
        try {
            System.out.println(test(null));
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public static String test(String filename) throws IOException{
        if (filename == null)
            throw new IOException("File not found");
        else
            return "File processing";
    }

}
