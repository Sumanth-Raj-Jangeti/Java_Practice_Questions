package com.fileIO.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream_ReadWrite {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        System.out.println(file.createNewFile()?"File has created successfully.":"File already exists!");
        //Reading using FileInputStream
        FileInputStream fis = new FileInputStream(file);
        int content;
        while((content=fis.read())!=-1)
        {
            System.out.print((char)content);
        }
        fis.close();
        String data="Mobile Number: 9912017943";
        FileOutputStream fos = new FileOutputStream(file,true);
        for(char ch:data.toCharArray()){
            fos.write(ch);
        }
        fis.close();
        fos.close();
    }
}

