package com.fileIO.practice;

import java.io.*;

public class BufferedReaderWriter{
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        //reading...
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String contentLine;
        while((contentLine=br.readLine())!=null){
            System.out.println(contentLine);
        }
        br.close();
        //writing...
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write("Computer Networks");
        bw.newLine();
        bw.write(new char[]{'S','P','R','I','N','G',' ','B','O','O','T'});
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
