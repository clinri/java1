package ru.progwards.clinri.T103;

import java.io.FileWriter;
import java.io.IOException;

public class Write2CharFile {


    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("key.txt", true);
            try {
                fileWriter.write("asdgfhiuywfiuybaivyubarfyvghairhfih354y987yt5387c5y087cv0y5087ct5qy087x5t786cnq5tn68ctq5386xcntq8095tgncqcxmq5tmcx90q5mc \n");
            } finally {
                fileWriter.close();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}
