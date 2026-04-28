package com.fileIO.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Find_NoOfLines {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int noOfLines=0;
        while((br.readLine())!=null){
            noOfLines++;
        }
        br.close();
        System.out.println("Total No.of Lines:"+noOfLines);
    }
}
