package com.fileIO.practice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Scanner_Read {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\MyInfo.txt");
        //System.out.println(file.createNewFile()?"File has created successfully.":"File already exists!");
        //Reading using Scanner class...
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        sc.close();
    }
}