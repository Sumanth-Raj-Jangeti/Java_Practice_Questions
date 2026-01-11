package com.strings.practice;

import java.util.Scanner;

public class Convert_Binary_to_Int_Manually {
    public static void main(String[] args) {
        //Converting Binary to integer.
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Binary Number:");
        int binary1=sc.nextInt();
        int originalbinary=binary1;
        int num1=0,power=0;
        while (binary1>0)
        {
            int rem1=binary1%10;
            num1+=(rem1*Math.pow(2,power));
            binary1=binary1/10;
            power++;
        }
        System.out.println("Integer form of "+originalbinary+" is:"+num1);
    }
}
