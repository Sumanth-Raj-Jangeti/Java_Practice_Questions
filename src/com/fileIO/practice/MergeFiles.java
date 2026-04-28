package com.fileIO.practice;

import java.io.*;

public class MergeFiles {
    public static void main(String[] args) throws IOException {
        File file1 = new File(".\\MyInfo.txt");
        File file2 = new File(".\\Others.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        String line,content1="",content2="";
        while((line=br1.readLine())!=null){
            content1 += line+"\n";
        }
        content1=content1.substring(0,content1.lastIndexOf("\n"));
        while((line=br2.readLine())!=null){
            content2 += line+"\n";
        }
        content2=content2.substring(0,content2.lastIndexOf("\n"));
        String input = content1+"\n"+content2;
        //writing...
        File file = new File(".\\Customer Details.txt");
        System.out.println(file.createNewFile()?"File has created successfully":"File already exists!");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(input);
        bw.flush();
        br1.close();
        br2.close();
        bw.close();
    }
}
