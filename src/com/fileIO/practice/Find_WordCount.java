package com.fileIO.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Find_WordCount {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currLine;
        int wordCount=0;
        while((currLine=br.readLine())!=null){
            wordCount+=currLine.split(" ").length;
        }
        System.out.println(wordCount);
    }
}
