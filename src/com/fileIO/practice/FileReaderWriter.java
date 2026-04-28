package com.fileIO.practice;

import java.io.*;

public class FileReaderWriter {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        //Reading...
        FileReader fr = new FileReader(file);
        char[] buffer = new char[1024];
        int content;
        while((content=fr.read(buffer))!=-1){
            System.out.print(new String(buffer,0,content));
        }
        fr.close();
        //writing...
        FileWriter fw = new FileWriter(file,true);//This constructor enables appending data into the specified file
        String input="\nToday I have started with character streams...";
        fw.write(input);
        char[] cbuf = {'\n','J','A','V','A'};
        fw.write(cbuf);
        fw.close();
    }
}