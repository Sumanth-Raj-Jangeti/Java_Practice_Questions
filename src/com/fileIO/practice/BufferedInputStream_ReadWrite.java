package com.fileIO.practice;

import java.io.*;

public class BufferedInputStream_ReadWrite {
    public static void main(String[] args) throws IOException {
        File f = new File(".\\MyInfo.txt");
        //Reading...
        FileInputStream fis = new FileInputStream(f);
        BufferedInputStream bis = new BufferedInputStream(fis);
        /*int content;
        while((content=bis.read())!=-1){
            System.out.print((char)content);
        }*/
        byte[] buffer = new byte[1024];
        int content;
        while((content=bis.read(buffer))!=-1){
            System.out.write(buffer,0,content);
        }
        //writing...
        FileOutputStream fos = new FileOutputStream(f,true);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String data = "\nLearning & practicing files IO";
        byte[] b = data.getBytes();
        bos.write(b);

        bis.close();bos.close();
    }
}