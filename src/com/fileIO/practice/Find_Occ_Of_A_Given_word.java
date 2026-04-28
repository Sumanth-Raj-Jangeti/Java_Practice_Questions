package com.fileIO.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Find_Occ_Of_A_Given_word {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currLine,target="and";
        int wordCount=0;
        while((currLine=br.readLine())!=null){
            String[] words=currLine.split(" ");
            for(String w:words){
                if(w.equals(target)){
                    wordCount++;
                }
            }
        }
        br.close();
        System.out.println("Total No.of Occurrences:"+wordCount);
    }
}
