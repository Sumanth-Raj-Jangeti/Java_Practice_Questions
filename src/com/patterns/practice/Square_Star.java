package com.patterns.practice;

public class Square_Star {
    public static void main(String[] args) {
        int n=4;//n represents the no.of rows & columns since it is a square...
        solidSquare(4);
        int rows=4,columns=10; //Because,In a rect-(rows!=columns) & In a square-(rows=columns)
        solidRect(rows,columns);
    }
    public static void solidSquare(int n)
    {
        System.out.println("SOLID SQUARE:");
        for(int i=1;i<=n;i++) //Controls the rows.
        {
            for(int j=1;j<=n;j++) //Controls the columns.
            {
                System.out.print("* ");
            }
            System.out.println(); //To move the pointer to the next line.
        }
    }
    public static void solidRect(int n,int m)
    {
        System.out.println("SOLID RECTANGLE:");
        for(int i=1;i<=n;i++)//Controls the rows.
        {
            for(int j=1;j<=m;j++)//Controls the columns.
            {
                System.out.print("* ");
            }
            System.out.println();//To move the pointer to the next line.
        }
    }
}
