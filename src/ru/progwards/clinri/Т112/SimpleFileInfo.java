package ru.progwards.clinri.Т112;

import java.io.File;
import java.util.Date;

public class SimpleFileInfo {
    public static void main(String[] args) {
        File fileInfo=new File("C:/Users/bandr/IdeaProjects/Progwards/src/ru/progwards/clinri/Т112/"); //SimpleFileInfo.java
        System. out.println( "exists: " + fileInfo.exists());
        System. out.println( "canExecute: " + fileInfo.canExecute());
        System. out.println( "lastModified: " + new Date(fileInfo.lastModified()));
        System. out.println( "length: " + fileInfo.length());
        System. out.println( "getParent: " + fileInfo.getParent());
        System. out.println( "getPath: " + fileInfo.getPath());
        System. out.println( "getName: " + fileInfo.getName());
        System. out.println( "isDirectory: " + fileInfo.isDirectory());
        System. out.println( "isFile: " + fileInfo.isFile());
        System. out.println( "isHidden: " + fileInfo.isHidden());
        System.out.println(System.getProperty("file.separator"));

    }







}
