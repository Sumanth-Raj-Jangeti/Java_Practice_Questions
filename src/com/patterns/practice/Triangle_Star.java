package com.patterns.practice;

public class Triangle_Star {
    public static void main(String[] args) {
        int n=4;
        rightAngled_Triangle(n); //Method Call
        invertedRightAngled_Triangle(n);//Method Call
        leftAngled_Triangle(n);//Method Call
        invertedLeftAngled_Triangle(n);//Method Call
        rightHead(n);//Method Call
        leftHead(n);//Method Call
        pyramid(n);//Method Call
        invertedPyramid(n);//Method Call
        diamond(n);//Method Call
    }
    public static void rightAngled_Triangle(int n)
    {
        System.out.println("RIGHT-ANGLED TRIANGLE:");
        for(int i=1;i<=n;i++)//Controls rows
        {
            for(int j=1;j<=i;j++)//Controls columns
            {
                System.out.print("*");
            }
            System.out.println();//next line
        }
    }
    public static void invertedRightAngled_Triangle(int n)
    {
        System.out.println("\nINVERTED RIGHT-ANGLED TRIANGLE:");
        for(int i = 1; i <= n; i++)//Controls rows
        {
            for(int j = n; j >= i; j--)//Controls columns
            {
                System.out.print("*");
            }
            System.out.println();//next line
        }
    }
    public static void leftAngled_Triangle(int n)
    {
        System.out.println("\nLEFT-ANGLED TRIANGLE:");
        for(int i=1;i<=n;i++)//controls rows
        {
            //For Spaces - same logic as inverted right-angled triangle
            for(int j=n-1;j>=i;j--)
            {
                System.out.print(" ");
            }
            //For *'s
            for(int k=1;k<=i;k++)
            {
                System.out.print("*");
            }
            System.out.println(); //next line
        }
    }
    public static void invertedLeftAngled_Triangle(int n)
    {
        System.out.println("\nINVERTED LEFT-ANGLED TRIANGLE:");
        for(int i=1;i<=n;i++)//control rows
        {
            //for spaces-using Right-Angled triangle logic
            for(int j=2;j<=i;j++)
            {
                System.out.print(" ");
            }
            //for *'s
            for(int k=n;k>=i;k--)
            {
                System.out.print("*");
            }
            System.out.println();//next line
        }
    }
          /*  WAP to print :
                           *
                           **
                           ***
                           **
                           *
          */
    public static void rightHead(int n)
    {
        System.out.println("\nRIGHT HEAD:");
        //TOP:
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        //BOTTOM:
        for(int i=1;i<=n;i++)
        {
            for(int j=n-1;j>=i;j--) //here, we need to use (n-1).if not same row will be printed.
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /*  WAP to print :
                         *
                        **
                       ***
                        **
                         *
     */
    public static void leftHead(int n)
    {
        System.out.println("\nLEFT HEAD:");
        //TOP:
        for(int i=1;i<=n;i++)
        {
            //for spaces...
            for(int j=n-1;j>=i;j--)
            {
                System.out.print(" ");
            }
            //for *'s...
            for(int k=1;k<=i;k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        //BOTTOM
        for(int i=1;i<=n;i++)
        {
            //for spaces...
            for(int j=1;j<=i;j++)
            {
                System.out.print(" ");
            }
            //for *'s
            for(int k=n-1;k>=i;k--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pyramid(int n)
    {
        System.out.println("\nPYRAMID:");
        for(int i=1;i<=n;i++)//controls rows
        {
            //For Spaces - same logic as inverted right-angled triangle
            for(int j=n-1;j>=i;j--)
            {
                System.out.print(" ");
            }
            //For *'s
            for(int k=1;k<=i;k++)
            {
                System.out.print(" *");
            }
            System.out.println(); //next line
        }
    }
    public static void invertedPyramid(int n)
    {
        System.out.println("\nINVERTED PYRAMID:");
        for(int i=1;i<=n;i++)//control rows
        {
            //for spaces-using Right-Angled triangle logic
            for(int j=2;j<=i;j++)
            {
                System.out.print(" ");
            }
            //for *'s
            for(int k=n;k>=i;k--)
            {
                System.out.print(" *");
            }
            System.out.println();//next line
        }
    }
    public static void diamond(int n)
    {
        System.out.println("\nDIAMOND:");
        //TOP:
        for(int i=1;i<=n;i++)//controls rows
        {
            //For Spaces - same logic as inverted right-angled triangle
            for(int j=n-1;j>=i;j--)
            {
                System.out.print(" ");
            }
            //For *'s
            for(int k=1;k<=i;k++)
            {
                System.out.print(" *");
            }
            System.out.println(); //next line
        }
        //BOTTOM:
        for(int i=1;i<=n;i++)//control rows
        {
            //for spaces-using Right-Angled triangle logic
            for(int j=1;j<=i;j++)
            {
                System.out.print(" ");
            }
            //for *'s
            for(int k=n-1;k>=i;k--)
            {
                System.out.print(" *");
            }
            System.out.println();//next line
        }
    }
}
