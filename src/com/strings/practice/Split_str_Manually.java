package com.strings.practice;

import java.util.Scanner;

public class Split_str_Manually {
    public static void main(String[] args) {
        //split a string without using split()...
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String:");
        String str=sc.nextLine();
        String word="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch!=' ')
            {
                word+=ch; //adding characters to a new string "word"
            }
            else
            {
                if(!word.isEmpty())
                {
                    System.out.println(word);
                    word="";
                }
            }
        }
        //Print the last word because the last word has no space after it.
        if(!word.isEmpty())
            System.out.println(word);
    }
}
