package com.strings.practice;

import java.util.Scanner;

public class Rev_each_word {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String:");
        String str=sc.nextLine();
        String revstr="";
        String[] words=str.split(" ");
        for (String w:words)
        {
            String revword="";
            for(int i=w.length()-1;i>=0;i--)
            {
                revword+=w.charAt(i);
            }
            revstr=revstr+revword+" ";
        }
        System.out.println(revstr);
        sc.close();
    }
}
