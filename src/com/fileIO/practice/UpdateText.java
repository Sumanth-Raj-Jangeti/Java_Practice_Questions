package com.fileIO.practice;

import java.io.*;

public class UpdateText {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currLine,update="";
        while((currLine=br.readLine())!=null){
            update += currLine.toUpperCase() + "\n";
        }
        update=update.substring(0,update.lastIndexOf("\n"));
        //writing...
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(update);
        bw.flush();
        br.close();
        bw.close();
    }
}
