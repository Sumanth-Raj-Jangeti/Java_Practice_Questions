package com.fileIO.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Find_LengthyLine {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currLine,lengthyLine="";
        int currLineNo=0,lengthyLineNo=0;
        while((currLine=br.readLine())!=null){
            currLineNo++;
            if(currLine.length() > lengthyLine.length()){
                lengthyLine=currLine;
                lengthyLineNo=currLineNo;
            }
        }
        br.close();
        System.out.println("Line No:"+lengthyLineNo+",LengthyLine:"+lengthyLine);
    }
}
